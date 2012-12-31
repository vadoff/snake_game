/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - EC: Pixel
 * Date: February 24, 2011
 *
 * File: Pixel.java
 *
 * Sources of Help: None for the Pixel java file.
 *
 * Pixel class and constructor, I created it to help
 * organize the data of each pixel in the snake game.
 */

import java.awt.*;

public class Pixel {
	private final Color DEFAULT = new Color(240, 240, 190);
	private Color c;
	private int x;
	private int y;
	private int snakeTimer;
	private boolean isRed;

	// Default Ctor
	public Pixel() {
		this(0, 0);
	}

	public Pixel(int x, int y) {
		this.setColor(DEFAULT);
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Method I added when I thought I might need it to compare the pixel
	 * locations, but I ended up not using it. A typical toString method that
	 * returns the X and Y coordinates (values which I didn't end up using in
	 * any of the logic either).
	 * 
	 * Params: None Return Value: String
	 */
	public String toString() {
		return this.getX() + "," + this.getY();
	}

	/**
	 * Method that lowers the snakeTimer value of the pixel by 1, if the value
	 * was greater than 0. This method is called once every frame.
	 * 
	 * Params: None Return Value: int
	 */
	public void refresh() {
		if (this.getSnakeTimer() > 0)
			this.setSnakeTimer(getSnakeTimer() - 1);
	}

	/**
	 * getSnakeTimer() is method that's used to update the snakeTimer values
	 * whenever the snakeHead is moving (once every frame).
	 * 
	 * Params: int pellets Return Value: None
	 */
	public void setSnakeHeadTimer(int pellets) {
		this.setSnakeTimer(pellets * 5 + 1);
	}

	/**
	 * getSnakeTimer() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: int
	 */
	public int getSnakeTimer() {
		return this.snakeTimer;
	}

	/**
	 * setSnakeTimer() is a typical mutator/setter method. This method also
	 * changes the Pixel's color to the snake body color or background depending
	 * on the snakeTimer value.
	 * 
	 * Params: int timer Return Value: None
	 */
	public void setSnakeTimer(int timer) {
		this.snakeTimer = timer;

		if (this.snakeTimer > 0)
			this.setColor(new Color(80, 120, 50));
		else
			this.setColor(DEFAULT);
	}

	/**
	 * getX() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: Color
	 */
	public Color getColor() {
		return this.c;
	}

	/**
	 * setColor() is a typical mutator/setter method.
	 * 
	 * Params: Color c Return Value: None
	 */
	public void setColor(Color c) {
		this.c = c;
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
	private void setY(int y) {
		this.y = y;
	}

	/**
	 * getRed() is a typical accessor/getter method.
	 * 
	 * Params: None Return Value: boolean
	 */
	public boolean getRed() {
		return this.isRed;
	}

	/**
	 * setRed() is a typical mutator/setter method. This method also changes the
	 * Pixel's color to red using another mutator/setter method.
	 * 
	 * Params: boolean isRed Return Value: None
	 */
	public void setRed(boolean isRed) {
		this.isRed = isRed;

		if (isRed == true)
			this.setColor(Color.RED);
	}
}
