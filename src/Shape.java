/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - Shape
 * Date: February 24, 2011
 *
 * File: Shape.java
 *
 * Sources of Help: None.
 *
 * Shape class and constructor.
 */

import java.awt.*;

/**
 * class Shape An abstract constructor that serves as a guideline for other
 * shapes (eg. Circle, Triangle, etc).
 */
public abstract class Shape {
	private String name;

	// Default Ctor
	public Shape() {
		this("");
	}

	public Shape(String name) {
		this.setName(name);
	}

	/**
	 * getName() is a typical accessor/getter method that returns the name.
	 * 
	 * Params: None Return Value: String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setName() is a typical mutator/setter method that sets the name.
	 * 
	 * Params: String name Return Value: None
	 */
	private void setName(String name) {
		this.name = name;
	}

	// abstract - No implementation
	public abstract void move(int xDelta, int yDelta);

	// abstract – No implementation
	public abstract void draw(Graphics g, Color c, boolean fill);
}