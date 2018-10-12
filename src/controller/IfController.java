package controller;

import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Piano;

public class IfController
{
	private ArrayList<Piano> pianoData = new ArrayList<Piano>(3);
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
		// lotsOfPiano();
		// stringList();
		insertLoop();
		loopBack();
		fruitLoop();
		pianoLoop();
	}

	/**
	 * builds a piano, asks for the model, color, and keys
	 */
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

				} else if (userInput.substring(0, 2).equalsIgnoreCase("no")
						|| userInput.substring(0, 2).equalsIgnoreCase("na") || userInput.equalsIgnoreCase("false"))
				{
					approved = true;
					userPiano.setIsElectric(false);
					JOptionPane.showMessageDialog(null, "Classic");

				} else
				{
					JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
					userInput = JOptionPane.showInputDialog(null, "Does it use electricity to power it?");
				}
			} else
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
				} else if (userInput.substring(0, 2).equalsIgnoreCase("no")
						|| userInput.substring(0, 2).equalsIgnoreCase("na") || userInput.equalsIgnoreCase("false"))
				{
					approved = true;
					userPiano.setIsGrand(false);
				} else
				{
					JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
					userInput = JOptionPane.showInputDialog(null, "Is it a grand piano?");
				}
			} else
			{
				JOptionPane.showMessageDialog(null, "Please answer yes/no or true/false");
				userInput = JOptionPane.showInputDialog(null, "Is it a grand piano?");
			}

		}

		userInput = JOptionPane.showInputDialog(null,
				"How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
		approved = false;
		while (!approved)
		{
			if (validInt(userInput))
			{
				if (Integer.parseInt(userInput) > 0)
				{
					approved = true;

				} else
				{
					JOptionPane.showMessageDialog(null, "You can't have no keys!");
					userInput = JOptionPane.showInputDialog(null,
							"How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
				}
			} else
			{
				userInput = JOptionPane.showInputDialog(null,
						"How many keys does your piano have? \n(Hint: an average piano has 88 keys)");
			}
		}
		userPiano.setNumberOfKeys(Integer.parseInt(userInput));

		JOptionPane.showMessageDialog(null, userPiano);
	}

	/**
	 * shows useless popups that shows lyrics to the song "All Stars" by Smash Mouth
	 */
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

	/**
	 * A loop that repeats the makePiano() call three times,
	 */
	private void pianoLoop()
	{
		for (int i = 0; i < 3; i++)
		{
			makePiano();
		}
	}

	/**
	 * Practice using ArrayList, makes a list of Smash Bros fighters and deletes and
	 * moves fighters not included
	 */
	private void stringList()
	{
		ArrayList<String> smashFighter = new ArrayList<String>(4);
		smashFighter.add("Mario");
		smashFighter.add("Link");
		smashFighter.add("Pikachu");
		smashFighter.add(1, "Luigi");
		smashFighter.add("Waluigi");
		smashFighter.add(4, "Isabelle");
		smashFighter.add("SANS UNDERTALE?!");
		smashFighter.add("Geno");
		smashFighter.add("Banjo-Kazooie");
		smashFighter.add("Shadow");
		smashFighter.remove("SANS UNDERTALE?!");

		ArrayList<String> rejects = new ArrayList<String>();

		String roster = "Fighters for Smash Ultimate:\n";
		int counter = 1;
		for (int index = smashFighter.size() - 1; index >= 0; index--)
		{
			if (index > 4)
			{
				String temp = smashFighter.get(index);
				rejects.add(temp);
				smashFighter.remove(index);

			}
		}
		for (int index = 0; index < smashFighter.size(); index++)
		{
			roster += counter + ".\t" + smashFighter.get(index) + "\n";
			counter++;

		}
		Random nextFight = new Random();
		roster += "Next Fight:\t" + smashFighter.get(nextFight.nextInt(smashFighter.size() - 1)) + " Vs. "
				+ smashFighter.get(nextFight.nextInt(smashFighter.size() - 1));
		JOptionPane.showMessageDialog(null, roster);
		JOptionPane.showMessageDialog(null, "Too bad!\n" + rejects.toString());

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

	/**
	 * Find and Replace function, enter a word/phrase and replace a selected portion
	 * with something else. (I was really bored)
	 */
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
			} else
			{
				approved = true;
			}
		}
		String originalString = insertInput;

		approved = false;
		// ask what letter/word/phrase should be located
		insertInput = JOptionPane.showInputDialog(null,
				"[ORIGINAL: \"" + fitString(originalString) + "\"]\n" + "What do you want to replace?");

		ArrayList<String> searchList = new ArrayList<String>();
		boolean onlyOne = true;
		while (!approved)
		{
			// null and "" are NOT acceptable inputs
			if (insertInput == null || insertInput.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter something");
			} else
			{
				boolean exception = false;
				int seperator = 0;
				int wordCount = 0;
				
				for (int index = 0; index < insertInput.length(); index++)
				{
					if (insertInput.substring(index, index + 1).equals(","))
					{
						onlyOne = false;
						searchList.add(insertInput.substring(seperator, index));
						seperator = index + 1;
						wordCount++;
					}
					if (wordCount > 1 && index == insertInput.length() - 1)
					{
						searchList.add(insertInput.substring(seperator, insertInput.length()));
					}
				}

				if (onlyOne)
				{
					searchList.add(insertInput);
				}
				JOptionPane.showMessageDialog(null,
						"[DEBUG]\n" + searchList.toString() + "\nSize: " + searchList.size());

				int approvedWords = 0;
				for (int element = 0; element < searchList.size(); element++)
				{
					String currentWord = searchList.get(element);

					// the phrase has to be of equal or less length, other wise the for loop won't
					// work
					if (currentWord.length() > originalString.length())
					{
						JOptionPane.showMessageDialog(null,
								"ERROR: Unable to locate, try again!" + "\n(Hint: Length exceeded original)");
						exception = true;
						element += searchList.size();
					} else if (currentWord.equals(""))
					{
						JOptionPane.showMessageDialog(null,
								"ERROR: Unable to locate, try again!" + "\n(Hint: Use of special character)");
						exception = true;
						element += searchList.size();
					} else
					{
						// loop checks to see if the inputed phrase appears at least once
						for (int index = 0; index <= originalString.length() - currentWord.length(); index++)
						{
							if (originalString.substring(index, index + currentWord.length()).equals(currentWord))
							{
								// if it appears, it's a valid input
								approvedWords++;
								index += originalString.length();
							}
						}
					}
				}
				// else if it never appears, error message pops up and the user must input again
				if (approvedWords == searchList.size())
				{
					approved = true;
				} else if (!exception)
				{
					JOptionPane.showMessageDialog(null,
							"ERROR: Unable to locate, try again!" + "\n(Hint: CaSe SeNsItIvE)");
					// JOptionPane.showMessageDialog(null,"[DEBUG]\n" + "Approved words: " +
					// approvedWords + " != " + searchList.size());
				}
			}
			if (!approved)
			{
				searchList.clear();
				// if it's not correct, same message pops up and the loop continues
				insertInput = JOptionPane.showInputDialog(null,
						fitString("[ORIGINAL: \"" + originalString + "\"]\n" + "What do you want to replace?"));
			}
		}

		// sorts list from largest to smallest length

		if (!onlyOne)
		{
			boolean ordered = false;
			int counter = 0;
			int failCount = 0;
			while (!ordered)
			{

				int element = (searchList.size() - 1) - (counter % searchList.size());
				String current = searchList.get(element);
				if (searchList.indexOf(current) == 0)
				{
					counter++;
				} else
				{
					String next = searchList.get(element - 1);
					if (current.length() > next.length())
					{
						String temp = current;
						String switchSet = next;
						searchList.set(element - 1, temp);
						searchList.set(element, switchSet);
						counter++;
					} else
					{
						counter++;
						failCount++;
					}
				}
				JOptionPane.showMessageDialog(null, "[DEBUG]\n" + searchList.toString() + "\nCurrent index: " + element
						+ "\nFailCount: " + failCount);
				if (failCount == searchList.size())
				{
					ordered = true;
					JOptionPane.showMessageDialog(null, "[DEBUG]\n" + searchList.toString() + "\nCurrent index: "
							+ element + "\nFailCount: " + failCount + "\nORDERED!");
				}

			}
		}

		approved = false;
		while (!approved)
		{
			insertInput = JOptionPane.showInputDialog(null, fitString("[ORIGINAL: \"" + originalString + "\"]\n"
					+ "What do you want to replace \"" + searchList.toString() + "\" with?"));
			if (insertInput == null)
			{
				JOptionPane.showMessageDialog(null, "Please enter something");
			} else
			{
				approved = true;
			}
		}
		String insertWord = insertInput;

		// container for new string
		// loop goes through each space of the original string to see if it should
		// replace it
		String finalString = originalString;
		for (int element = 0; element < searchList.size(); element++)
		{
			String replacePart = searchList.get(element);
			String modifiedString = "";
			for (int index = 0; index < finalString.length() - replacePart.length() + 1; index++)
			{
				// if it does have the keyword, it inserts the word to the new string
				if (finalString.substring(index, index + replacePart.length()).equals(replacePart))
				{
					modifiedString += insertWord;
					// loop will now skip checking the rest of that section as it is already changed
					index += replacePart.length() - 1;
				} else
				{
					// if index is almost at the end of the String, then that means there's nothing
					// left to check,so the rest doesn't need to be changed
					if (index == (finalString.length() - replacePart.length()))
					{
						modifiedString += finalString.substring(index, finalString.length());
					} else
					{
						// add letter to modifiedString and move on to the next
						modifiedString += finalString.substring(index, index + 1);
					}
				}
			}
			finalString = modifiedString;
		}
		JOptionPane.showMessageDialog(null, fitString(finalString, 200));

	}

	/**
	 * Enter a word/phrase and it will tell you how many vowels an consonants there
	 * are (Note: special characters and spaces counts as consonants, needs to be
	 * improved)
	 */
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
			if (searchChar.equalsIgnoreCase("a") || searchChar.equalsIgnoreCase("e") || searchChar.equalsIgnoreCase("i")
					|| searchChar.equalsIgnoreCase("o") || searchChar.equalsIgnoreCase("u")
					|| searchChar.equalsIgnoreCase("y"))
			{
				vowelCount++;
			} else if (!searchChar.equals(" "))
			{
				consonantCount++;
			}
		}
		JOptionPane.showMessageDialog(null, "There are " + vowelCount + " vowels and " + consonantCount
				+ " consonants in the phrase \"" + fitString(inputBack) + "\"");

	}

	/**
	 * Enter a word/phrase and it will turn it into a crappy meme
	 */
	private void fruitLoop()
	{
		Random coinFlip = new Random();
		String outputMulti = "";
		String changeCase = "";

		String fruitInput = JOptionPane.showInputDialog(null,
				"</WORD IMPROVER/>\n" + "Enter in the word you want to improve");
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
			} else
			{
				outputMulti += changeCase.toLowerCase() + " ";
			}
		}
		JOptionPane.showMessageDialog(null, fitString(outputMulti));
	}

	/**
	 * Checks to see if input is a valid integer
	 * 
	 * @param maybeInt the input you want to check to see if it's an integer
	 * @return if it is an integer, it will return true, else it returns false
	 */
	public boolean validInt(String maybeInt)
	{
		boolean isValid = false;

		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		} catch (NumberFormatException nope)
		{
			JOptionPane.showMessageDialog(null, "Please enter an integer");
		}
		return isValid;
	}

	/**
	 * Checks to see if input is a valid double
	 * 
	 * @param maybeInt the input you want to check to see if it's a double
	 * @return if it is a double, it will return true, else it returns false
	 */
	public boolean validDouble(String maybeDouble)
	{
		boolean isValid = false;
		try
		{
			Double.parseDouble(maybeDouble);
			isValid = true;
		} catch (NumberFormatException nope)
		{
			JOptionPane.showMessageDialog(null, "Please enter a double");
		}
		return isValid;
	}

	// method overloading for optional parameters
	/**
	 * Wraps String to fit vertically
	 * 
	 * @param sample the String you want to format
	 * @return String that is vertically formatted
	 */
	public String fitString(String sample)
	{
		return fitString(sample, 140, 0);
	}

	/**
	 * Wraps String to fit vertically
	 * 
	 * @param sample          The String you want to format
	 * @param characterLength How many character per line until split (Default: 140
	 *                        characters)
	 * @return String that is vertically formatted
	 */
	public String fitString(String sample, int characterLength)
	{
		return fitString(sample, characterLength, 0);

	}

	/**
	 * Wraps String to fit in column rather than across the screen
	 * 
	 * @param sample          The String you want to format
	 * @param characterLength How long the String should go for each line (Default:
	 *                        140 characters)
	 * @param splitType       Formatting type: 1 = split text with hyphen, 2 =
	 *                        splits text with no format, 0 (default) = new line
	 *                        after word ends
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
		} else if (splitType == 2)
		{
			splitString = "\n";// splits text
		} else
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
				} else if (counter == characterLength && sample.substring(index, index + 1).equals(" "))
				{
					smallString += "\n";
					counter = 0;
				} else
				{
					counter++;
					smallString += sample.substring(index, index + 1);
				}

			} else if (splitType != 1 && splitType != 2)
			{
				if (sample.substring(index, index + 1).equals(" ") && counter > characterLength)
				{
					smallString += splitString;
					counter = 0;
				} else
				{
					smallString += sample.substring(index, index + 1);
					counter++;
				}
			}

		}

		return smallString;

	}

}