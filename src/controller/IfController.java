package controller;

import model.Piano;
import javax.swing.JOptionPane;

public class IfController
{
	private Piano userPiano;

	/**
	 * Builds the instance of the Controller.
	 */
	public IfController()
	{

	}

	/**
	 * This is where the program starts calling methods to run the program
	 */
	public void start()
	{
		String userInput = JOptionPane.showInputDialog(null, "What model is your piano?");
		userPiano.setBrand(userInput);

		userInput = JOptionPane.showInputDialog(null, "What color is it?");
		userPiano.setColor(userInput);

		userInput = JOptionPane.showInputDialog(null, "Does it use electricity to power it?");
		boolean approved = false;
		while (!approved)
		{
			if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("true"))
			{
				approved = true;
				userPiano.setIsElectric(true);
				JOptionPane.showMessageDialog(null, "Your piano needs power!");
				JOptionPane.showMessageDialog(null, "better have an outlet handy");
				
			}else if(userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("false"))
			{
				approved = true;
				userPiano.setIsElectric(false);
				JOptionPane.showMessageDialog(null, "classic");
				
			} else 
			{
				JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
			}
		}

	}

	public boolean validInt(String maybeInt)
	{
		boolean isValid = false;

		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException nope)
		{
			JOptionPane.showMessageDialog(null, "Please enter an integer");
		}
		return isValid;
	}
}
