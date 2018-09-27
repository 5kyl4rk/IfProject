package controller;

import java.util.Random;

import javax.swing.JOptionPane;

import model.Piano;

public class IfController
{
	private Piano userPiano;

	/**
	 * Builds the instance of the Controller.
	 */
	public IfController()
	{
		userPiano = new Piano();
	}

	/**
	 * This is where the program starts calling methods to run the program
	 */
	public void start()
	{
		loopy();
		fruitLoop();
		makePiano();

	}
	
	private void makePiano()
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

			}
			else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("false"))
			{
				approved = true;
				userPiano.setIsElectric(false);
				JOptionPane.showMessageDialog(null, "Classic");

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
			}
		}
		
		approved = false;
		userInput = JOptionPane.showInputDialog("Is it a grand piano?");
		while(!approved)
		{
			if(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("true"))
			{
				approved = true;
				userPiano.setIsGrand(true);
			}
			else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("false"))
			{
				approved = true;
				userPiano.setIsGrand(false);
			}
			else
			{
				userInput = JOptionPane.showInputDialog(null, "Please answer yes/no or true/false");
			}
		}

		userInput = JOptionPane.showInputDialog(null, "How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
		while (!validInt(userInput))
		{
			userInput = JOptionPane.showInputDialog(null, "How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
		}
		userPiano.setNumberOfKeys(Integer.parseInt(userInput));
	}

	private void loopy()
	{
		// define a variable before the loop
		boolean isFinished = false;
		int someCount = 1;

		// test code
		while (!isFinished)
		{
			// do code
			// JOptionPane.showMessageDialog(null, "Surprise!");

			switch (someCount)
			{
			case 1:
				JOptionPane.showMessageDialog(null, "someBODY once told me");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "the world was gonna rule me");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "I ain't the sharpest tool in the shed");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "She was looking kinda dumb");
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "With her finger and her thumb");
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "in the shape of an 'L' on her forehead");
				break;

			}
			someCount++;
			// update test variable
			if (someCount > 6)
			{
				isFinished = true;
			}

		}
	}

	private void fruitLoop()
	{
		Random coinFlip = new Random();
		String fruitInput = JOptionPane.showInputDialog(null, "Enter in the word you want to improve");
		String multiString = fruitInput;

		int spaceNum = fruitInput.length();
		String outputMulti = "";
		String changeCase = "";
		for (int i = 0; i < spaceNum; i++)
		{
			changeCase = multiString.substring(i, i + 1);
			
			if (coinFlip.nextInt(2) == 0)
			{

				outputMulti += changeCase.toUpperCase();

			}
			else
			{
				outputMulti += changeCase.toLowerCase();
			}
		}
		JOptionPane.showMessageDialog(null, outputMulti);

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

	public boolean validDouble(String maybeDouble)
	{
		boolean isValid = false;
		try
		{
			Double.parseDouble(maybeDouble);
			isValid = true;
		}
		catch (NumberFormatException nope)
		{
			JOptionPane.showMessageDialog(null, "Please enter a double");
		}
		return isValid;
	}
}
