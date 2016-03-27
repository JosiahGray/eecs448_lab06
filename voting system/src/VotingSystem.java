import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.*;
//import java.util.ArrayList;

public class VotingSystem
{
	//declare GUI components
	private JPanel mainPanel;
	private JPanel namePanel;
	private JPanel buttonPanel;
	
	private JLabel instructions;
	private JLabel firstLabel;
	private JLabel lastLabel;
	private JLabel result;
	
	private JTextField firstText;
	private JTextField lastText;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	
	//declare voting candidates
	private String candidate1 = "Hilary Clinton";
	private String candidate2 = "Ted Cruz";
	private String candidate3 = "Bernie Sanders";
	private String candidate4 = "Donald Trump";
	
	public VotingSystem()
	{
		//set up components
		mainPanel = new JPanel(new GridLayout(0,1));
		namePanel = new JPanel(new GridLayout(2,2));
		buttonPanel = new JPanel(new GridLayout(2,2));
		
		instructions = new JLabel("Enter your first and last name, then select a candidate.");
		firstLabel = new JLabel("First name: ");
		lastLabel = new JLabel("Last name: ");
		firstText = new JTextField(10);
		lastText = new JTextField(10);
		
		button1 = new JButton(candidate1);
		button2 = new JButton(candidate2);
		button3 = new JButton(candidate3);
		button4 = new JButton(candidate4);
		
		result = new JLabel("");
		
		//load listeners
		button1.addActionListener(button1Listener());
		button2.addActionListener(button2Listener());
		button3.addActionListener(button3Listener());
		button4.addActionListener(button4Listener());
		
		//load name panel
		namePanel.add(firstLabel);
		namePanel.add(firstText);
		namePanel.add(lastLabel);
		namePanel.add(lastText);
		
		//load button panel
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		
		//load main panel
		mainPanel.add(instructions);
		mainPanel.add(namePanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(result);
	}
	
	public Component getContent()
	{
		return mainPanel;
	}
	
	//helper method to cast vote
	private void castVote(String candidate)
	{
		BufferedWriter outputStream = null;
		
		String firstName = firstText.getText();
		String lastName = lastText.getText();
		firstName = firstName.replaceAll("\\s", "");
		lastName = lastName.replaceAll("\\s", "");
		
		//check to see if user did not enter first and last names
		if(firstName.equals("") || lastName.equals(""))
		{
			result.setText("ERROR: You did not enter a valid first and last name!");
		}
		else
		{
			String newFileName = (lastName + "_" + firstName + "_ballot.txt");
			File testVoter = new File(newFileName);
			
			//check to see if user has already voted before
			if(testVoter.exists())
			{
				result.setText("ERROR: You have already voted!");
			}
			//if this is a new voter, create a new ballot
			else
			{
				try
				{
					outputStream = new BufferedWriter(new FileWriter(newFileName));
					outputStream.write(candidate);
					//outputStream.newLine();
					outputStream.close();
					result.setText(firstName + " " + lastName + " successfully voted for " + candidate + ".");
				}
				catch(Exception a)
				{
					result.setText("ERROR: An error has occurred when writing the ballot!");
				}
			}
		}
	}
	
	//vote for candidate1
	private ActionListener button1Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				castVote(candidate1);
			}
		};
		
		return listener;
	}
	
	//vote for candidate2
	private ActionListener button2Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				castVote(candidate2);
			}
		};
		
		return listener;
	}
	
	//vote for candidate3
	private ActionListener button3Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				castVote(candidate3);
			}
		};
		
		return listener;
	}
	
	//vote for candidate4
	private ActionListener button4Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				castVote(candidate4);
			}
		};
		
		return listener;
	}
}
