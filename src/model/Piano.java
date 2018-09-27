package model;

public class Piano
{
	// Declaration section
	// Data Member section
	/*
	 * Also called instance variables these are special - they get a "default" value
	 * All numbers -> 0 boolean -> false Objects -> null
	 */
	private String brand;
	private String color;
	private boolean isElectric;
	private boolean isGrand;
	private int numberOfKeys;

	/**
	 * Default constructor for a piano Initializes all variables to valid but "bad"
	 * values Used for later customization
	 */
	public Piano()
	{
		this.brand = "Nintendo Labo: Cardboard Piano edition (null)";
		this.color = "Expensive cardboard (null)";
		this.numberOfKeys = -88;
	}

	/**
	 * Initializes a Piano instance
	 * 
	 * @param brand
	 *            The type of piano
	 * @param color
	 *            The color or make of the piano
	 * @param isElectric
	 *            If it's electric or uses electric elements
	 * @param isGrand
	 *            If it's a grand piano
	 * @param numberOfKeys
	 *            The number of keys it has
	 */
	public Piano(String brand, String color, boolean isElectric, boolean isGrand, int numberOfKeys)
	{
		this.brand = brand;
		this.color = color;
		this.isElectric = isElectric;
		this.isGrand = isGrand;
		this.numberOfKeys = numberOfKeys;
	}

	public String getBrand()
	{
		return brand;
	}

	public String getColor()
	{
		return color;
	}

	public boolean getIsElectric()
	{
		return isElectric;
	}

	public boolean getIsGrand()
	{
		return isGrand;
	}

	public int getNumberOfKeys()
	{
		return numberOfKeys;
	}

	public void setBrand(String brand)
	{
		String fixBrand = brand.substring(0, 1).toUpperCase() + brand.substring(1, brand.length());
		this.brand = fixBrand;
	}

	public void setColor(String color)
	{
		String fixColor = color.toLowerCase();
		this.color = fixColor;
	}

	public void setIsElectric(boolean electric)
	{
		isElectric = electric;
	}

	public void setIsGrand(boolean grand)
	{
		isGrand = grand;
	}

	public void setNumberOfKeys(int keys)
	{
		numberOfKeys = keys;
	}

	public String toString()
	{
		String grand = " piano";
		String electric = " ";
		if(isGrand) 
		{
			grand = " grand piano";
		} 
		if(isElectric)
		{
			electric = ", it uses electricity ";
		}
		String description = "[" + brand +" piano]\n" + 
							 "This is a "+ color + grand + electric + 
							 "and has a whopping " + numberOfKeys +" keys.";
		return description;
	}
}
