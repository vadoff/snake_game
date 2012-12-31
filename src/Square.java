/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Square
 * Date: February 24, 2011
 *
 * File: Square.java
 *
 * Sources of Help: None.
 *
 * Square class and constructor.
 */

import java.awt.*;

/**
 * class Square Contains constructors for Square objects and various methods
 * that access and modify those object's values. Also has a draw method.
 */
public class Square extends ARectangle {
	private int side;

	// Default Ctor
	public Square() {
		this(new Point(0, 0), 0);
	}

	public Square(int x, int y, int side) {
		this(new Point(x, y), side);
	}

	public Square(Point upperLeft, int side) {
		super("Square", new Point(upperLeft));
		this.setSide(side);
	}

	public Square(Square r) {
		super(r);
		this.setSide(r.getSide());
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return super.toString() + " Sides: " + this.getSide();
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

		if (((Square) o).getSide() == this.getSide())
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
			g.fillRect(x, y, this.getSide(), this.getSide());
		else
			g.drawRect(x, y, this.getSide(), this.getSide());
	}

	/**
	 * getSide() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getSide() {
		return this.side;
	}

	/**
	 * setSide() is a typical mutator/setter method.
	 * 
	 * Params: int s Return Value: None
	 */
	private void setSide(int s) {
		this.side = s;
	}
}