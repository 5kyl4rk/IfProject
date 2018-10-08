package controller;

import java.util.Random;
import java.util.ArrayList;
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
		// loopy();
		stringList();
		insertLoop();
		loopBack();
		fruitLoop();
		pianoLoop();
	}

	private void makePiano()
	{

		String userInput = JOptionPane.showInputDialog(null, "What model is your piano?");
		while (userInput == null || userInput.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please answer the question");
			userInput = JOptionPane.showInputDialog(null, "What model is your piano?");
		}
		userPiano.setBrand(userInput);

		userInput = JOptionPane.showInputDialog(null, "What color is it?");
		while (userInput == null || userInput.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please answer the question");
			userInput = JOptionPane.showInputDialog(null, "What color is it?");
		}
		userPiano.setColor(userInput);

		userInput = JOptionPane.showInputDialog(null, "Does it use electricity to power it?");
		boolean approved = false;
		while (!approved)
		{
			if (userInput != null && userInput.length() >= 2)
			{
				if (userInput.substring(0, 2).equalsIgnoreCase("ye") || userInput.equalsIgnoreCase("true"))
				{
					approved = true;
					userPiano.setIsElectric(true);
					JOptionPane.showMessageDialog(null, "Your piano needs power!");
					JOptionPane.showMessageDialog(null, "better have an outlet handy");

				}
				else if (userInput.substring(0, 2).equalsIgnoreCase("no") || userInput.substring(0, 2).equalsIgnoreCase("na") || userInput.equalsIgnoreCase("false"))
				{
					approved = true;
					userPiano.setIsElectric(false);
					JOptionPane.showMessageDialog(null, "Classic");

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
					userInput = JOptionPane.showInputDialog(null, "Does it use electricity to power it?");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
				userInput = JOptionPane.showInputDialog(null, "Does it use electricity to power it?");
			}
		}

		approved = false;
		userInput = JOptionPane.showInputDialog("Is it a grand piano?");
		while (!approved)
		{
			if (userInput != null && userInput.length() >= 2)
			{
				if (userInput.substring(0, 2).equalsIgnoreCase("ye") || userInput.equalsIgnoreCase("true"))
				{
					approved = true;
					userPiano.setIsGrand(true);
				}
				else if (userInput.substring(0, 2).equalsIgnoreCase("no") || userInput.substring(0, 2).equalsIgnoreCase("na") || userInput.equalsIgnoreCase("false"))
				{
					approved = true;
					userPiano.setIsGrand(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
					userInput = JOptionPane.showInputDialog(null, "Is it a grand piano?");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
				userInput = JOptionPane.showInputDialog(null, "Is it a grand piano?");
			}

		}

		userInput = JOptionPane.showInputDialog(null, "How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
		approved = false;
		while (!approved)
		{
			if (validInt(userInput))
			{
				if (Integer.parseInt(userInput) > 0)
				{
					approved = true;

				}
				else
				{
					JOptionPane.showMessageDialog(null, "You can't have no keys!");
					userInput = JOptionPane.showInputDialog(null, "How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
				}
			}
			else
			{
				userInput = JOptionPane.showInputDialog(null, "How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
			}
		}
		userPiano.setNumberOfKeys(Integer.parseInt(userInput));

		JOptionPane.showMessageDialog(null, userPiano);
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

	private void pianoLoop()
	{
		for (int i = 0; i < 3; i++)
		{
			makePiano();
		}
	}

	private void stringList()
	{
		ArrayList<String> smashFighter = new ArrayList<String>(2);
		smashFighter.add("Mario");
		smashFighter.add("Link");
		smashFighter.add("Pikachu");
		smashFighter.add(1, "Luigi");
		smashFighter.add("Waluigi");
		smashFighter.add(4, "Isabelle");
		smashFighter.add("Geno");
		smashFighter.add("Banjo-Kazooie");

		String roster = "Fighter for Smash Ultimate:\n";
		for (int index = 0; index < smashFighter.size(); index++)
		{
			if (index > 4)
			{
				smashFighter.remove(index);
			}
			else
			{
			roster += (index + 1) + ".\t" + smashFighter.get(index) + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, roster);

	}

	private void lotsOfPiano()
	{
		// Local variable are only visible in the method they are defined in!
		// They only have SCOPE to that method

		ArrayList<Piano> myPianos = new ArrayList<Piano>();

		Piano coolPiano = new Piano();
		Piano oldPiano = new Piano();

		myPianos.add(coolPiano);
		myPianos.add(coolPiano);
		myPianos.add(oldPiano);

		// Standard forward loop
		for (int index = 0; index < myPianos.size(); index += 1)
		{
			// Good for display, or minor changes
			JOptionPane.showMessageDialog(null, myPianos.get(index).getBrand());

			// Good for remove, replace, change multiple values
			Piano currentPiano = myPianos.get(index);
			currentPiano.setBrand("The brand is " + index);

		}

		// Standard backward loop
		// great for removing
		for (int index = myPianos.size() - 1; index >= 0; index -= 1)
		{

		}

		for (Piano current : myPianos)
		{
			JOptionPane.showMessageDialog(null, "The piano is named: " + current.getBrand());
		}
	}

	private void insertLoop()
	{
		String insertInput = JOptionPane.showInputDialog(null, "<WORD REPLACER>\n" + "Enter a phrase");
		boolean approved = false;
		while (!approved)
		{
			// if user closes pop-up, exit method
			if (insertInput == null)
			{
				return;
			}
			if (insertInput.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter something");
				insertInput = JOptionPane.showInputDialog(null, "<WORD REPLACER>\n" + "Enter a phrase");
			}
			else
			{
				approved = true;
			}
		}
		String originalString = insertInput;

		approved = false;
		// ask what letter/word/phrase should be located
		insertInput = JOptionPane.showInputDialog(null, "[ORIGINAL: \"" + fitString(originalString) + "\"]\n" + "What do you want to replace?");
		while (!approved)
		{
			// null and "" are NOT acceptable inputs
			if (insertInput == null || insertInput.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter something");
			}
			// the phrase has to be of equal or less length, other wise the for loop won't
			// work
			else if (insertInput.length() > originalString.length())
			{
				JOptionPane.showMessageDialog(null, "ERROR: Unable to locate, try again!" + "\n(Hint: Length exceeded original)");
			}
			else
			{
				// loop checks to see if the inputed phrase appears at least once
				for (int index = 0; index <= originalString.length() - insertInput.length(); index++)
				{
					if (originalString.substring(index, index + insertInput.length()).equals(insertInput))
					{
						// if it appears, it's a valid input
						approved = true;
					}
				}
				// else if it never appears, error message pops up and the user must input again
				if (!approved)
				{
					JOptionPane.showMessageDialog(null, "ERROR: Unable to locate, try again!" + "\n(Hint: CaSe SeNsItIvE)");
				}
			}
			if (!approved)
			{
				// if it's not correct, same message pops up and the loop continues
				insertInput = JOptionPane.showInputDialog(null, "[ORIGINAL: \"" + fitString(originalString) + "\"]\n" + "What do you want to replace?");
			}
		}

		String replacePart = insertInput;

		approved = false;
		while (!approved)
		{
			insertInput = JOptionPane.showInputDialog(null, "[ORIGINAL: \"" + fitString(originalString) + "\"]\n" + "What do you want to replace \"" + fitString(replacePart) + "\" with?");
			if (insertInput == null)
			{
				JOptionPane.showMessageDialog(null, "Please enter something");
			}
			else
			{
				approved = true;
			}
		}
		String insertWord = insertInput;

		String modifiedString = "";// container for new string
		// loop goes through each space of the original string to see if it should
		// replace it
		for (int index = 0; index < originalString.length() - replacePart.length() + 1; index++)
		{
			// if it does have the keyword, it inserts the word to the new string
			if (originalString.substring(index, index + replacePart.length()).equals(replacePart))
			{
				modifiedString += insertWord;
				// loop will now skip checking the rest of that section as it is already changed
				index += replacePart.length() - 1;
			}
			else
			{
				// if index is almost at the end of the loop, then that means there's nothing
				// left to check,so the rest doesn't need to be changed
				if (index == (originalString.length() - replacePart.length()))
				{
					modifiedString += originalString.substring(index, originalString.length());
				}
				else
				{
					// add letter to modifiedString and move on to the next
					modifiedString += originalString.substring(index, index + 1);
				}
			}

		}
		JOptionPane.showMessageDialog(null, fitString(modifiedString, 0, 1));

	}

	private void loopBack()
	{
		String inputBack = JOptionPane.showInputDialog(null, "[WORD STATS]\n" + "Enter a phrase");
		if (inputBack == null)
		{
			return;
		}
		if (inputBack.equals(""))
		{
			inputBack = "Tony Hawk Pro Skater 4";
		}
		int vowelCount = 0;
		int consonantCount = 0;
		for (int i = 0; i < inputBack.length(); i++)
		{
			String searchChar = inputBack.substring(i, i + 1);
			if (searchChar.equalsIgnoreCase("a") || searchChar.equalsIgnoreCase("e") || searchChar.equalsIgnoreCase("i") || searchChar.equalsIgnoreCase("o") || searchChar.equalsIgnoreCase("u")
					|| searchChar.equalsIgnoreCase("y"))
			{
				vowelCount++;
			}
			else if (!searchChar.equals(" "))
			{
				consonantCount++;
			}
		}
		JOptionPane.showMessageDialog(null, "There are " + vowelCount + " vowels and " + consonantCount + " consonants in the phrase \"" + fitString(inputBack) + "\"");

	}

	private void fruitLoop()
	{
		Random coinFlip = new Random();
		String outputMulti = "";
		String changeCase = "";

		String fruitInput = JOptionPane.showInputDialog(null, "</WORD IMPROVER/>\n" + "Enter in the word you want to improve");
		String multiString = fruitInput;
		if (fruitInput == null || multiString.equals(""))
		{
			multiString = "Are you feeling it now Mr. Krabs?";
		}
		int spaceNum = multiString.length();

		for (int index = 0; index < spaceNum; index++)
		{
			changeCase = multiString.substring(index, index + 1);

			if (coinFlip.nextInt(2) == 0)
			{
				outputMulti += changeCase.toUpperCase() + " ";
			}
			else
			{
				outputMulti += changeCase.toLowerCase() + " ";
			}
		}
		JOptionPane.showMessageDialog(null, fitString(outputMulti));
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

	// method overloading for optional parameters
	public String fitString(String sample)
	{
		return fitString(sample, 140, 0);
	}

	public String fitString(String sample, int characterLength)
	{
		return fitString(sample, characterLength, 0);

	}

	/**
	 * Wraps String to fit in column rather than across the screen
	 * 
	 * @param sample
	 *            The String you want to format
	 * @param characterLength
	 *            How long the String should go for each line (Default: 140
	 *            characters)
	 * @param splitType
	 *            Formatting type: 1 = split text with hyphen, 2 = splits text with
	 *            no format, 0 (default) = new line after word ends
	 * @return String that's vertically arranged
	 */
	public String fitString(String sample, int characterLength, int splitType)
	{
		String smallString = "";
		String splitString = "";
		int counter = 0;

		if (splitType == 1)
		{
			splitString = "-\n";// split text with hyphen
		}
		else if (splitType == 2)
		{
			splitString = "\n";// splits text
		}
		else
		{
			splitString = "\n";// splits text after word ends
		}

		if (characterLength <= 0)
		{
			characterLength = 140;
		}

		for (int index = 0; index < sample.length(); index += 1)
		{
			if (splitType == 1 || splitType == 2)
			{
				if (counter == characterLength && !sample.substring(index, index + 1).equals(" "))
				{
					smallString += splitString;
					counter = 0;
					smallString += sample.substring(index, index + 1);
				}
				else if (counter == characterLength && sample.substring(index, index + 1).equals(" "))
				{
					smallString += "\n";
					counter = 0;
				}
				else
				{
					counter++;
					smallString += sample.substring(index, index + 1);
				}

			}
			else if (splitType != 1 && splitType != 2)
			{
				if (sample.substring(index, index + 1).equals(" ") && counter > characterLength)
				{
					smallString += splitString;
					counter = 0;
				}
				else
				{
					smallString += sample.substring(index, index + 1);
					counter++;
				}
			}

		}

		return smallString;

	}

}