import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel instructions;
	private JLabel result;
	
	public SafeConverter()
	{
		panel = new JPanel( new GridLayout(0,1));
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		instructions = new JLabel("Enter a temperature to convert from F to C:");
		result = new JLabel("A temperature has not been input yet");
		
		//Load the listener
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
}
