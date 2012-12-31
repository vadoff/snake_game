/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Rectangle
 * Date: February 24, 2011
 *
 * File: Rectangle.java
 *
 * Sources of Help: None.
 *
 * Rectangle class and constructor.
 */

import java.awt.*;

/**
 * class Rectangle Contains constructors for Rectangle objects and various
 * methods that access and modify those object's values. Also has a draw method.
 */
public class Rectangle extends ARectangle {
	private int width;
	private int height;

	// Default Ctor
	public Rectangle() {
		this(new Point(0, 0), 0, 0);
	}

	public Rectangle(int x, int y, int width, int height) {
		this(new Point(x, y), width, height);
	}

	public Rectangle(Point upperLeft, int width, int height) {
		super("Rectangle", new Point(upperLeft));
		this.setWidth(width);
		this.setHeight(height);
	}

	public Rectangle(Rectangle r) {
		super(r);
		this.setWidth(r.getWidth());
		this.setHeight(r.getHeight());
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return super.toString() + " Width: " + this.getWidth() + " Height: "
				+ this.getHeight();
	}

	/**
	 * equals() is a method that compares both the calling and passed object to
	 * see if they're of the same type, and have the same field values.
	 * 
	 * Params: Object o Return Value: boolean
	 */
	public boolean equals(Object o) {
		if (super.equals(o) == false)
			return false;

		if (((Rectangle) o).getWidth() == this.getWidth()
				&& ((Rectangle) o).getHeight() == this.getHeight())
			return true;
		else
			return false;
	}

	/**
	 * draw() is a method that draws the object using the passed color and
	 * graphics, it will fill or outline the object based off of the passed
	 * boolean value.
	 * 
	 * Params: Graphics g, Color c, boolean fill Return Value: None
	 */
	public void draw(Graphics g, Color c, boolean fill) {
		if (c == null)
			c = Color.BLACK;

		g.setColor(c);

		int x = super.getUpperLeft().getX();
		int y = super.getUpperLeft().getY();

		if (fill == true)
			g.fillRect(x, y, this.getWidth(), this.getHeight());
		else
			g.drawRect(x, y, this.getWidth(), this.getHeight());
	}

	/**
	 * getWidth() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * setWidth() is a typical mutator/setter method.
	 * 
	 * Params: int w Return Value: None
	 */
	private void setWidth(int w) {
		this.width = w;
	}

	/**
	 * getHeight() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * setHeight() is a typical mutator/setter method.
	 * 
	 * Params: int h Return Value: None
	 */
	private void setHeight(int h) {
		this.height = h;
	}
}