import javax.swing.*;

public class DiceProgramDriver
{
	private static void createAndDisplayGUI()
	{
		//set up frame
		JFrame frame = new JFrame("Dice Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		DiceProgram dice = new DiceProgram();
		
		frame.getContentPane().add(dice.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		createAndDisplayGUI();

	}

}
