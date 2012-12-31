/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - ARectangle
 * Date: February 24, 2011
 *
 * File: ARectangle.java
 *
 * Sources of Help: None.
 *
 * ARectangle class and constructor.
 */

/**
 * ARectangle is an abstract class that serves as a guideline for Square and
 * Rectangle objects.
 */
public abstract class ARectangle extends Shape {
	// Upper left corner - Common to all rectangular shapes
	private Point upperLeft;

	// Default Ctor
	public ARectangle() {
		this("ARectangle", new Point(0, 0));
	}

	public ARectangle(String name, int x, int y) {
		this(name, new Point(x, y));
	}

	public ARectangle(String name, Point upperLeft) {
		super(name); // Calls the super constructor to set the name
		setUpperLeft(new Point(upperLeft));
	}

	public ARectangle(ARectangle r) {
		super(r.getName()); // Calls the super constructor to set the name
		setUpperLeft(new Point(r.getUpperLeft()));
	}

	/**
	 * move() is a method that alters the x and y coordinates of the object's
	 * points, thus moving the object.
	 * 
	 * Params: int xDelta and int yDelta Return Value: none
	 */
	public void move(int xDelta, int yDelta) {
		setUpperLeft(new Point(this.getUpperLeft().getX() + xDelta, this
				.getUpperLeft().getY() + yDelta));
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return super.getName() + ": Upper Left Corner: Point: ("
				+ this.getUpperLeft().getX() + "," + this.getUpperLeft().getY()
				+ ")";
	}

	/**
	 * equals() is a method that compares both the calling and passed object to
	 * see if they're of the same type, and have the same field values.
	 * 
	 * Params: Object o Return Value: boolean
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (this.getClass() != o.getClass())
			return false;

		if (this.getUpperLeft().equals(((ARectangle) o).getUpperLeft()))
			return true;
		else
			return false;
	}

	/**
	 * getUpperLeft() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getUpperLeft() {
		return this.upperLeft;
	}

	/**
	 * setUpperLeft() is a typical mutator/setter method.
	 * 
	 * Params: Point p Return Value: None
	 */
	private void setUpperLeft(Point p) {
		this.upperLeft = p;
	}
}