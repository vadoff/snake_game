/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Circle
 * Date: February 24, 2011
 *
 * File: Circle.java
 *
 * Sources of Help: None.
 *
 * Circle class and constructor.
 */

import java.awt.*;

/**
 * class Circle Contains constructors for Circle objects and various methods
 * that access and modify those object's values. Also has a draw method.
 */
public class Circle extends Shape {
	private Point center;
	private int radius;

	// Default Ctor
	public Circle() {
		this(new Point(0, 0), 0);
	}

	public Circle(Point center, int radius) {
		this.setCenter(new Point(center));
		this.setRadius(radius);
	}

	public Circle(Circle c) {
		this.setCenter(new Point(c.getCenter()));
		this.setRadius(c.getRadius());
	}

	/**
	 * move() is a method that alters the x and y coordinates of the object's
	 * points, thus moving the object.
	 * 
	 * Params: int xDelta and int yDelta Return Value: none
	 */
	public void move(int xDelta, int yDelta) {
		setCenter(new Point(this.getCenter().getX() + xDelta, this.getCenter()
				.getY() + yDelta));
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return "Center: Point: (" + this.getCenter().getX() + ","
				+ this.getCenter().getY() + "); Radius: " + this.getRadius();
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

		if (this.getCenter().equals(((Circle) o).getCenter())
				&& this.getRadius() == ((Circle) o).getRadius())
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

		int x = this.getCenter().getX();
		int y = this.getCenter().getY();

		if (fill == true)
			g.fillOval(x - this.getRadius(), y - this.getRadius(),
					this.getRadius() * 2, this.getRadius() * 2);
		else
			g.drawOval(x - this.getRadius(), y - this.getRadius(),
					this.getRadius() * 2, this.getRadius() * 2);
	}

	/**
	 * getCenter() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getCenter() {
		return this.center;
	}

	/**
	 * setCenter() is a typical mutator/setter method.
	 * 
	 * Params: Point center Return Value: None
	 */
	private void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * getRadius() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 * setRadius() is a typical mutator/setter method.
	 * 
	 * Params: int radius Return Value: None
	 */
	private void setRadius(int radius) {
		this.radius = radius;
	}
}