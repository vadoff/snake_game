/*
 * Name: Randolph Lee
 * Account: cs8fec
 * HW: Homework 6 - TestExtraCredit
 * Date: February 24, 2011
 *
 * File: TestExtraCredit.java
 *
 * Sources of Help: Various websites in order to get the
 * key bindings functional, and a bit of help for the 2D
 * arrays, otherwise this was all me. It took me 9+ hours,
 * but it was fun and a good learning experience =)
 *
 * Java application to play snake.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * class TestExtraCredit is an extension of JPanel (only way to use key bindings
 * that I know of). TestExtraCredit contains the main() as well as most of the
 * logic driving the snake game.
 */
public class TestExtraCredit extends JPanel {
	private static Graphics g;
	private static String dir;
	private static boolean gameover;
	private static int pellets;
	// Sets the speed of the game - frame delay
	private static final int DELAY = 80;

	public TestExtraCredit() {
		// Key bindings for game controls
		getInputMap().put(KeyStroke.getKeyStroke("UP"), "UP");
		getActionMap().put("UP", up);
		getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
		getActionMap().put("LEFT", left);
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DOWN");
		getActionMap().put("DOWN", down);
		getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
		getActionMap().put("RIGHT", right);
	}

	/**
	 * main() is the driver for this application.
	 * 
	 * Creates a DrawingPanel, a 2D array of Pixel objects, and calls on other
	 * methods.
	 * 
	 * InterruptedException in order to use sleep
	 * 
	 * Params: String[] args - Not used. Return Value: None
	 */
	public static void main(String[] args) throws InterruptedException // Exception
																		// must
																		// be
																		// thrown
																		// to
																		// use
																		// sleep
	{
		JFrame f = new JFrame();

		DrawingPanel panel = new DrawingPanel(512, 256);
		g = panel.getGraphics(); // Graphics context for objects to draw
		f.getContentPane().add(new TestExtraCredit());

		f.setVisible(true);
		f.setAlwaysOnTop(true);

		// Plays the intro
		intro();

		// Sets the snake background screen
		Rectangle snakeBackground = new Rectangle(0, 0, 511, 255);
		snakeBackground.draw(g, new Color(240, 240, 190), true);

		// Creates and initializes a 2D array of Pixel objects
		Pixel[][] pArray = new Pixel[64][32];
		for (int x = 0; x < 64; x++) {
			for (int y = 0; y < 32; y++) {
				pArray[x][y] = new Pixel(x, y);
			}
		}

		// Starts the animation
		run(pArray);

		// Plays the gameover
		gameover();
	}

	/**
	 * run() is a method I split from main in order to organize the structure
	 * more cleanly. It contains almost all of the logic used in the program, as
	 * well as rechecking/drawing the pixels every frame.
	 * 
	 * InterruptedException in order to use sleep
	 * 
	 * Params: Pixel[][] pArray Return Value: None
	 */
	public static void run(Pixel[][] pArray) throws InterruptedException {
		dir = "UP"; // Initializes snake to go up
		// Snake starting position at the middle/bottom screen
		int snakeHeadX = 31;
		int snakeHeadY = 31;
		pellets = 0; // Determines score and snake length
		gameover = false;
		boolean pelletEaten = false;

		// Randomly generates a pellet to eat
		generateRedDot(pArray);

		while (gameover == false) {
			// Logic
			if (dir.equals("UP")) {
				// Checks if moving up will go out of bounds
				if (snakeHeadY <= 0)
					gameover = true;
				// Checks if moving will hit a tail
				else if (pArray[snakeHeadX][snakeHeadY - 1].getSnakeTimer() > 1)
					gameover = true;
				else if (pArray[snakeHeadX][snakeHeadY - 1].getRed() == true) {
					pellets++;
					pArray[snakeHeadX][--snakeHeadY].setSnakeHeadTimer(pellets);
					pArray[snakeHeadX][snakeHeadY].setRed(false);
					generateRedDot(pArray);
				} else
					pArray[snakeHeadX][--snakeHeadY].setSnakeHeadTimer(pellets);
			} else if (dir.equals("LEFT")) {
				// Checks if moving left will go out of bounds
				if (snakeHeadX <= 0)
					gameover = true;
				// Checks if moving will hit a tail
				else if (pArray[snakeHeadX - 1][snakeHeadY].getSnakeTimer() > 1)
					gameover = true;
				else if (pArray[snakeHeadX - 1][snakeHeadY].getRed() == true) {
					pellets++;
					pArray[--snakeHeadX][snakeHeadY].setSnakeHeadTimer(pellets);
					pArray[snakeHeadX][snakeHeadY].setRed(false);
					generateRedDot(pArray);
				} else
					pArray[--snakeHeadX][snakeHeadY].setSnakeHeadTimer(pellets);
			} else if (dir.equals("DOWN")) {
				// Checks if moving down will go out of bounds
				if (snakeHeadY >= 31)
					gameover = true;
				// Checks if moving will hit a tail
				else if (pArray[snakeHeadX][snakeHeadY + 1].getSnakeTimer() > 1)
					gameover = true;
				else if (pArray[snakeHeadX][snakeHeadY + 1].getRed() == true) {
					pellets++;
					pArray[snakeHeadX][++snakeHeadY].setSnakeHeadTimer(pellets);
					pArray[snakeHeadX][snakeHeadY].setRed(false);
					generateRedDot(pArray);
				} else
					pArray[snakeHeadX][++snakeHeadY].setSnakeHeadTimer(pellets);
			} else if (dir.equals("RIGHT")) {
				// Checks if moving right will go out of bounds
				if (snakeHeadX >= 63)
					gameover = true;
				// Checks if moving will hit a tail
				else if (pArray[snakeHeadX + 1][snakeHeadY].getSnakeTimer() > 1)
					gameover = true;
				else if (pArray[snakeHeadX + 1][snakeHeadY].getRed() == true) {
					pellets++;
					pArray[++snakeHeadX][snakeHeadY].setSnakeHeadTimer(pellets);
					pArray[snakeHeadX][snakeHeadY].setRed(false);
					generateRedDot(pArray);
				} else
					pArray[++snakeHeadX][snakeHeadY].setSnakeHeadTimer(pellets);
			}

			// Draws the frame
			for (int x = 0; x < 64; x++) {
				for (int y = 0; y < 32; y++) {
					Square p = new Square(x * 8, y * 8, 7);
					p.draw(g, pArray[x][y].getColor(), true);
					// Refresh checks each pixel and lowers their SnakeTimer
					pArray[x][y].refresh();
				}
			}
			Thread.sleep(DELAY);
		}
	}

	/**
	 * intro() is another method I split from main. Contains the basic intro
	 * graphics before the start of the game.
	 * 
	 * InterruptedException in order to use sleep
	 * 
	 * Params: None Return Value: None
	 */
	public static void intro() throws InterruptedException {
		// Generates gameover background
		Rectangle introBackground = new Rectangle(0, 0, 511, 255);
		introBackground.draw(g, new Color(50, 100, 150), true);

		g.setColor(new Color(150, 210, 90));
		g.setFont(new Font("Small", Font.BOLD, 20));
		g.drawString("Use the arrow keys to control your snake!", 50, 220);

		Rectangle border = new Rectangle(15, 30, 480, 140);
		border.draw(g, new Color(100, 150, 50), true);
		border.draw(g, Color.YELLOW, false);

		Rectangle innerBorder = new Rectangle(35, 50, 440, 100);
		innerBorder.draw(g, new Color(80, 120, 50), true);

		Rectangle column1 = new Rectangle(105, 31, 20, 139);
		column1.draw(g, new Color(100, 150, 50), true);

		Rectangle column2 = new Rectangle(200, 31, 20, 139);
		column2.draw(g, new Color(100, 150, 50), true);

		Rectangle column3 = new Rectangle(290, 31, 20, 139);
		column3.draw(g, new Color(100, 150, 50), true);

		Rectangle column4 = new Rectangle(385, 31, 20, 139);
		column4.draw(g, new Color(100, 150, 50), true);

		Rectangle box1 = new Rectangle(35, 50, 69, 99);
		box1.draw(g, Color.YELLOW, false);

		Rectangle box2 = new Rectangle(125, 50, 74, 99);
		box2.draw(g, Color.YELLOW, false);

		Rectangle box3 = new Rectangle(220, 50, 69, 99);
		box3.draw(g, Color.YELLOW, false);

		Rectangle box4 = new Rectangle(310, 50, 74, 99);
		box4.draw(g, Color.YELLOW, false);

		Rectangle box5 = new Rectangle(405, 50, 69, 99);
		box5.draw(g, Color.YELLOW, false);

		// "S"
		Triangle triS1 = new Triangle(new Point(55, 120), new Point(35, 120),
				new Point(35, 80));
		triS1.draw(g, Color.YELLOW, true);

		Triangle triS2 = new Triangle(new Point(83, 80), new Point(104, 120),
				new Point(104, 80));
		triS2.draw(g, Color.YELLOW, true);

		Line lineS1 = new Line(new Point(35, 60), new Point(82, 149));
		lineS1.draw(g, Color.YELLOW, true);

		// "N"
		Triangle triN1 = new Triangle(new Point(170, 50), new Point(170, 75),
				new Point(150, 50));
		triN1.draw(g, Color.YELLOW, true);

		Triangle triN2 = new Triangle(new Point(150, 100), new Point(150, 149),
				new Point(190, 149));
		triN2.draw(g, Color.YELLOW, true);

		Line lineN1 = new Line(new Point(170, 125), new Point(150, 125));
		lineN1.draw(g, Color.YELLOW, true);

		Line lineN2 = new Line(new Point(160, 113), new Point(150, 113));
		lineN2.draw(g, Color.YELLOW, true);

		// "A"
		for (int i = 0; i < 95; i += 10) {
			Triangle triA1 = new Triangle(new Point(253, 51 + i), new Point(
					220, 149), new Point(289, 149));
			triA1.draw(g, Color.YELLOW, true);
		}

		// "K"
		Triangle triK1 = new Triangle(new Point(336, 50), new Point(336, 80),
				new Point(356, 50));
		triK1.draw(g, Color.YELLOW, true);

		Triangle triK2 = new Triangle(new Point(336, 149), new Point(336, 119),
				new Point(356, 149));
		triK2.draw(g, Color.YELLOW, true);

		Triangle triK3 = new Triangle(new Point(360, 100), new Point(384, 138),
				new Point(384, 60));
		triK3.draw(g, Color.YELLOW, true);

		Circle cK1 = new Circle(new Point(360, 100), 20);
		cK1.draw(g, Color.YELLOW, false);

		// "E"
		Line lineE1 = new Line(new Point(430, 51), new Point(430, 149));
		lineE1.draw(g, Color.YELLOW, true);

		Line lineE2 = new Line(new Point(430, 84), new Point(473, 84));
		lineE2.draw(g, Color.YELLOW, true);

		Line lineE3 = new Line(new Point(430, 117), new Point(473, 117));
		lineE3.draw(g, Color.YELLOW, true);

		Line lineE4 = new Line(new Point(462, 85), new Point(462, 117));
		lineE4.draw(g, Color.YELLOW, true);

		// Intro delay
		Thread.sleep(4000);
	}

	/**
	 * gameover() is a method I split from run(). It contains the ending
	 * sequence animation followed by the printing of the player's score. I
	 * tried messing around with trying to start a new game, but it was a bit
	 * too tricky since I don't know how to properly stall the program for a
	 * keybinded response. Perhaps a sleep loop with a KeyListener would have
	 * worked...
	 * 
	 * InterruptedException in order to use sleep
	 * 
	 * Params: None Return Value: None
	 */
	public static void gameover() throws InterruptedException {
		// Generates gameover background
		Rectangle gameoverBackground = new Rectangle(0, 0, 511, 255);
		gameoverBackground.draw(g, Color.BLACK, true);

		// Short animation of "gameover" texts
		for (int x = 0; x < 12; x++) {
			Random rand = new Random();
			int shade = rand.nextInt(150) + 50;

			g.setColor(new Color(shade, shade, shade));
			g.setFont(new Font("Medium", Font.BOLD, 50));

			// Random offset values for the random flying text
			int xOffset = rand.nextInt(300) - 150;
			int yOffset = rand.nextInt(300) - 150;

			g.drawString("Game Over", 130 + xOffset, 130 + yOffset);
			Thread.sleep(150);
		}

		// Big "gameover" text in red
		g.setColor(new Color(255, 10, 10));
		g.setFont(new Font("Large", Font.BOLD, 92));
		g.drawString("Game Over", 10, 135);

		// Score
		g.setColor(new Color(255, 10, 10));
		g.setFont(new Font("Small", Font.BOLD, 30));
		g.drawString("Score: " + pellets * 100, 150, 200);
	}

	/**
	 * generateRedDot() is a helper method that randomly generates a pellet
	 * location, then calculates if that position is a valid location to spawn
	 * (not in the snake).
	 * 
	 * Params: Pixel[][] pArray Return Value: None
	 */
	public static void generateRedDot(Pixel[][] pArray) {
		boolean redSuccess = false;

		// Keeps trying to generate a pellet, until it's valid
		while (redSuccess == false) {
			Random rand = new Random();
			int x = rand.nextInt(63);
			int y = rand.nextInt(31);

			if (pArray[x][y].getSnakeTimer() == 0
					&& pArray[x][y].getRed() == false) {
				pArray[x][y].setRed(true);
				redSuccess = true;
			}
		}
	}

	// Action listeners (not methods):
	private Action up = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Some limited key correction so a player can't suicide his snake
			 * accidently by trying to go in the opposite direction
			 */
			if (dir.equals("DOWN"))
				dir = "DOWN";
			else
				dir = "UP";
		}
	};

	private Action left = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Some limited key correction so a player can't suicide his snake
			 * accidently by trying to go in the opposite direction
			 */
			if (dir.equals("RIGHT"))
				dir = "RIGHT";
			else
				dir = "LEFT";
		}
	};

	private Action down = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Some limited key correction so a player can't suicide his snake
			 * accidently by trying to go in the opposite direction
			 */
			if (dir.equals("UP"))
				dir = "UP";
			else
				dir = "DOWN";
		}
	};

	private Action right = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Some limited key correction so a player can't suicide his snake
			 * accidently by trying to go in the opposite direction
			 */
			if (dir.equals("LEFT"))
				dir = "LEFT";
			else
				dir = "RIGHT";
		}
	};
}
