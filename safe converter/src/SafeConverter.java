import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter
{
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JButton buttonFC;
	private JButton buttonFK;
	private JButton buttonCF;
	private JButton buttonCK;
	private JButton buttonKF;
	private JButton buttonKC;
	private JTextField text;
	private JLabel instructions;
	private JLabel result;
	
	public SafeConverter()
	{
		mainPanel = new JPanel(new GridLayout(0,1));
		buttonPanel = new JPanel(new GridLayout(2,3));
		
		buttonFC = new JButton("F to C");
		buttonFK = new JButton("F to K");
		buttonCF = new JButton("C to F");
		buttonCK = new JButton("C to K");
		buttonKF = new JButton("K to F");
		buttonKC = new JButton("K to C");
		
		instructions = new JLabel("Enter a temperature to convert:");
		text = new JTextField(3);//3 cols, not 20 chars
		result = new JLabel("A temperature has not been input yet");
		
		//Load the listeners
		buttonFC.addActionListener(buttonFCListener());
		buttonFK.addActionListener(buttonFKListener());
		buttonCF.addActionListener(buttonCFListener());
		buttonCK.addActionListener(buttonCKListener());
		buttonKF.addActionListener(buttonKFListener());
		buttonKC.addActionListener(buttonKCListener());
		
		//load the button panel
		buttonPanel.add(buttonFC);
		buttonPanel.add(buttonCF);
		buttonPanel.add(buttonKF);
		buttonPanel.add(buttonFK);
		buttonPanel.add(buttonCK);
		buttonPanel.add(buttonKC);
		
		//load the main panel
		mainPanel.add(instructions);
		mainPanel.add(text);
		mainPanel.add(buttonPanel);
		mainPanel.add(result);
	}
	
	public Component getContent()
	{
		return mainPanel;
	}
	
	//convert F to C
	private ActionListener buttonFCListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempF = Double.parseDouble(input); //convert String to double
					double tempC = (tempF-32)*(5.0/9.0); //convert F to C
					String newText = "Temp in C: " + String.format("%.2f",tempC); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
	
	//convert F to K
	private ActionListener buttonFKListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempF = Double.parseDouble(input); //convert String to double
					double tempK = (tempF-32)*(5.0/9.0)+273.15; //convert F to K
					String newText = "Temp in K: " + String.format("%.2f",tempK); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
	
	//convert C to F
	private ActionListener buttonCFListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempC = Double.parseDouble(input); //convert String to double
					double tempF = (tempC*(9.0/5.0))+32; //convert C to F
					String newText = "Temp in F: " + String.format("%.2f",tempF); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
	
	//convert C to K
	private ActionListener buttonCKListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempC = Double.parseDouble(input); //convert String to double
					double tempK = tempC+273.15; //convert C to K
					String newText = "Temp in K: " + String.format("%.2f",tempK); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
	
	//convert K to F
	private ActionListener buttonKFListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempK = Double.parseDouble(input); //convert String to double
					double tempF = (tempK-273.15)*(9.0/5.0)+32; //convert K to F
					String newText = "Temp in F: " + String.format("%.2f",tempF); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
	
	//convert K to C
	private ActionListener buttonKCListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				try{
					double tempK = Double.parseDouble(input); //convert String to double
					double tempC = tempK-273.15; //convert K to C
					String newText = "Temp in C: " + String.format("%.2f",tempC); //convert double to String and display 2 decimal places
					
					//display conversion result
					result.setText(newText);
					System.out.println(newText);
				}
				catch(Exception a){
					result.setText("ERROR: You must enter a number!");
				}
			}
		};
		
		return listener;
	}
}
