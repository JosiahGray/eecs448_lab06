import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class DiceProgram
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel instructions;
	private JLabel result;
	
	public DiceProgram()
	{
		//create GUI components
		panel = new JPanel(new GridLayout(0,1));
		button = new JButton("Roll");
		text = new JTextField(3);
		instructions = new JLabel("Enter an integer for the number of sides for the die.");
		result = new JLabel("Die does not have sides yet.");
		
		//load listener
		button.addActionListener(buttonListener());
		
		//load the panel
		panel.add(instructions);
		panel.add(text);
		panel.add(button);
		panel.add(result);
	}
	
	public Component getContent()
	{
		return panel;
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//get input from textfield
				String input = text.getText();
				
				/*
				 * attempt to convert input to an integer
				 * use that integer as the number of faces of a die
				 * display a random number between 1 and the number of faces
				 * if anything goes wrong, throw an error
				 */
				try{
					int sides = Integer.parseInt(input);
					
					Random rand = new Random();
					int diceRoll = rand.nextInt(sides) +1;
					String newText = "Result: " + diceRoll;
							
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a positive integer!");
				}
			}
		};
		return listener;
	}
}
