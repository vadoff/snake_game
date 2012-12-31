/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Point
 * Date: February 24, 2011
 *
 * File: Point.java
 *
 * Sources of Help: None.
 *
 * Point class and constructor.
 */

/**
 * class Point Contains constructors for Point objects and various methods that
 * access and modify those object's values.
 */
public class Point {
	private int x;
	private int y;

	// Default Ctor
	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		setX(x);
		setY(y);
	}

	public Point(Point point) {
		setX(point.getX());
		setY(point.getY());
	}

	/**
	 * move() is a method that alters the x and y coordinates of the object's
	 * points, thus moving the object.
	 * 
	 * Params: int xDelta and int yDelta Return Value: none
	 */
	public void move(int xDelta, int yDelta) {
		this.setX(this.getX() + xDelta);
		this.setY(this.getY() + yDelta);
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return "Point: (" + getX() + "," + getY() + ")";
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

		if (this.getX() == ((Point) o).getX()
				&& this.getY() == ((Point) o).getY())
			return true;
		else
			return false;
	}

	/**
	 * getX() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * setX() is a typical mutator/setter method.
	 * 
	 * Params: int x Return Value: None
	 */
	// Private! so Points are immutable
	private void setX(int x) {
		this.x = x;
	}

	/**
	 * getY() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * setY() is a typical mutator/setter method.
	 * 
	 * Params: int y Return Value: None
	 */
	// Private! so Points are immutable
	private void setY(int y) {
		this.y = y;
	}
}