/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Triangle
 * Date: February 24, 2011
 *
 * File: Triangle.java
 *
 * Sources of Help: None.
 *
 * Triangle class and constructor.
 */

import java.awt.*;

/**
 * class Triangle Contains constructors for Triangle objects and various methods
 * that access and modify those object's values. Also has a draw method.
 */
public class Triangle extends Shape {
	private Point p1;
	private Point p2;
	private Point p3;

	// Default Ctor
	public Triangle() {
		this(new Point(0, 0), new Point(0, 0), new Point(0, 0));
	}

	public Triangle(Point p1, Point p2, Point p3) {
		setP1(new Point(p1));
		setP2(new Point(p2));
		setP3(new Point(p3));
	}

	public Triangle(Triangle tri) {
		setP1(new Point(tri.getP1()));
		setP2(new Point(tri.getP2()));
		setP3(new Point(tri.getP3()));
	}

	/**
	 * move() is a method that alters the x and y coordinates of the object's
	 * points, thus moving the object.
	 * 
	 * Params: int xDelta and int yDelta Return Value: none
	 */
	public void move(int xDelta, int yDelta) {
		setP1(new Point(this.getP1().getX() + xDelta, this.getP1().getY()
				+ yDelta));
		setP2(new Point(this.getP2().getX() + xDelta, this.getP2().getY()
				+ yDelta));
		setP3(new Point(this.getP3().getX() + xDelta, this.getP3().getY()
				+ yDelta));
	}

	/**
	 * toString() is a method that returns information about the object.
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return "Triangle: Point: (" + this.getP1().getX() + ","
				+ this.getP1().getY() + "), Point: (" + +this.getP2().getX()
				+ "," + this.getP2().getY() + "), Point: ("
				+ +this.getP3().getX() + "," + this.getP3().getY() + ")";
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

		if (this.getP1().equals(((Triangle) o).getP1())
				&& this.getP2().equals(((Triangle) o).getP2())
				&& this.getP3().equals(((Triangle) o).getP3()))
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

		Polygon poly = new Polygon();
		poly.addPoint(this.getP1().getX(), this.getP1().getY());
		poly.addPoint(this.getP2().getX(), this.getP2().getY());
		poly.addPoint(this.getP3().getX(), this.getP3().getY());

		/*
		 * if(fill == true) g.fillPolygon(poly); else g.drawPolygon(poly);
		 */

		g.drawPolygon(poly);
	}

	/**
	 * setP1() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getP1() {
		return this.p1;
	}

	/**
	 * setP1() is a typical mutator/setter method.
	 * 
	 * Params: Point p1 Return Value: None
	 */
	private void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * setP2() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getP2() {
		return this.p2;
	}

	/**
	 * setP1() is a typical mutator/setter method.
	 * 
	 * Params: Point p1 Return Value: None
	 */
	private void setP2(Point p2) {
		this.p2 = p2;
	}

	/**
	 * setP3() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Point
	 */
	public Point getP3() {
		return this.p3;
	}

	/**
	 * setP3() is a typical mutator/setter method.
	 * 
	 * Params: Point p3 Return Value: None
	 */
	private void setP3(Point p3) {
		this.p3 = p3;
	}
}