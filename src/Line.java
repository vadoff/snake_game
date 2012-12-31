/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Line
 * Date: February 24, 2011
 *
 * File: Line.java
 *
 * Sources of Help: None.
 *
 * Line class and constructor.
 */

import java.awt.*;

/**
 * class Line Contains constructors for Line objects and various methods that
 * access and modify those object's values. Also has a draw method.
 */
public class Line extends Shape {
	private Point start;
	private Point end;

	// Default Ctor
	public Line() {
		this(new Point(0, 0), new Point(0, 0));
	}

	public Line(Point start, Point end) {
		setStart(new Point(start));
		setEnd(new Point(end));
	}

	public Line(Line line) {
		setStart(new Point(line.getStart()));
		setEnd(new Point(line.getEnd()));
	}

	/**
	 * move() is a method that alters the x and y coordinates of the object's
	 * points, thus moving the object.
	 * 
	 * Params: int xDelta and int yDelta Return Value: none
	 */
	public void move(int xDelta, int yDelta) {
		setStart(new Point(this.getStart().getX() + xDelta, this.getStart()
				.getY() + yDelta));
		setEnd(new Point(this.getEnd().getX() + xDelta, this.getEnd().getY()
				+ yDelta));
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return "Line: Point: (" + this.getStart().getX() + ","
				+ this.getStart().getY() + ") to Point: ("
				+ this.getEnd().getX() + "," + this.getEnd().getY() + ")";
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

		if (this.getStart().equals(((Line) o).getStart())
				&& this.getEnd().equals(((Line) o).getEnd()))
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

		int x1 = this.getStart().getX();
		int y1 = this.getStart().getY();
		int x2 = this.getEnd().getX();
		int y2 = this.getEnd().getY();

		g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * getStart() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getStart() {
		return this.start;
	}

	/**
	 * setStart() is a typical mutator/setter method.
	 * 
	 * Params: Point p Return Value: None
	 */
	private void setStart(Point p) {
		this.start = p;
	}

	/**
	 * getEnd() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getEnd() {
		return this.end;
	}

	/**
	 * setEnd() is a typical mutator/setter method.
	 * 
	 * Params: Point p Return Value: None
	 */
	private void setEnd(Point p) {
		this.end = p;
	}
}
