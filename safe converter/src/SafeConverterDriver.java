import javax.swing.JFrame;

public class SafeConverterDriver
{
	private static void createAndDisplayGUI()
	{
		//set up frame
		JFrame frame = new JFrame("Temperature Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		SafeConverter converter = new SafeConverter();
		
		frame.getContentPane().add(converter.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();

	}

}
