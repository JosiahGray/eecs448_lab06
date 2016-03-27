import javax.swing.JFrame;

public class VotingSystemDriver
{
	private static void createAndDisplayGUI()
	{
		//set up frame
		JFrame frame = new JFrame("Voting System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		VotingSystem voter = new VotingSystem();
		
		frame.getContentPane().add(voter.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();

	}
}
