package assignment8;
/**
 * @author Eric Chan
 * @version 11/30/15
 */
import processing.core.PApplet;

class Disk {
	protected float x;
	protected float y;
	protected float rx;
	protected float ry;
	
	protected float xSpeed;
	protected float ySpeed;
	
	PApplet canvas;

	protected int col;
	protected float red=0, green=0, blue=0, alpha=0;
	protected int numOfMoves = 0;
	protected int[] valueList = {10,20,50,100};
	protected int diskValue;
	protected String valueString;
	private static int numOfDisks = 0;
	
	public Disk ( PApplet canvas )
	{
		this.canvas = canvas;
		x = canvas.random(0,  canvas.width); 
		y = canvas.random(0, canvas.height);
		rx = canvas.random(30, 80);
		ry = canvas.random(rx,rx);
		xSpeed = canvas.random(10, 20 );
		ySpeed = canvas.random(10, 20 );
		int valueRandom = (int)(Math.random() * 4);
		diskValue = valueList[valueRandom];
		
	
		valueString = Integer.toString(diskValue);
		numOfDisks++;
		
		if (numOfDisks%4 == 0) {
			red = 255; 
			blue = 100;
		}
		else if (numOfDisks%4 == 1)  {
			red = 255; 
			blue = 100;
			green = 255;
		}
		else if (numOfDisks%4 == 2)  {
			blue = 100;
			green = 255;
		}
		else if (numOfDisks%4 == 3)  {
			blue = 255;
			red = 150;
		}
		
		alpha = 255;
		col = canvas.color(red, green, blue, alpha);
		
		
		
	}
	
	public void move() {
		// update position based on speed
		x += xSpeed;
		y += ySpeed;
		// bouncing logic - see if the ball hits any of the edges
		// note how we are referring to the width and height
		// instance vars on the PApplet object

		if (x > canvas.width) {
			x = canvas.width;
			xSpeed *= -1;
			
		}
		if (x < 0) {
			x = 0;
			xSpeed *= -1;
			
		}
		if (y > canvas.height) {
			y = canvas.height;
			ySpeed *= -1;
			
		}
		if (y < 0) {
			y = 0;
			ySpeed *= -1;
			
		}
		//adjust the color settings
		numOfMoves++;
		if (numOfMoves > 2 && alpha > 0) {
			alpha--;
			numOfMoves = 0;
			
		}

		col = canvas.color(red, green, blue, alpha);
		canvas.fill(col);
		canvas.stroke(col);
		// call the ellipse method on the PApplet object to draw
		// this object to the canvas
		this.canvas.ellipse(x, y, rx, ry);
	
	}
	
	/**
	 * 
	 * @return diskValue
	 */
	public int getValue () {
		return diskValue;
	}
	/**
	 * 
	 * @return disk value as string
	 */
	
	public String getValueString() {
		return valueString;
	}
	/**
	 * 
	 * @return gets rx
	 */
	public float getRx () {
		return rx;
	}
	/**
	 * 
	 * @return gets ry
	 */
	public float getRy() {
		return ry;
	}
	/**
	 * 
	 * @return gets x
	 */
	public float getXNum() {
		return x;
	}
	/**
	 * 
	 * @return gets y
	 */
	public float getYNum() {
		return y;		
	}
	/**
	 * sets red
	 * @param num
	 * 
	 */
	public void setRed(int num) {
		red = num;
	}
	/**
	 * sets green
	 * @param num
	 */
	public void setGreen(int num) {
		green = num;
	}
	/**
	 * sets blue
	 * @param num
	 */
	public void setBlue (int num) {
		blue = num;
	}
	/**
	 * sets value 
	 * @param empty
	 */
	public void setValueString(String empty) {
		valueString = empty;
	}
	/**
	 * sets value as int
	 * @param zero
	 */
	public void setValueInt(int zero) {
		diskValue = zero;
	}
	/**
	 * gets alpha
	 * @return
	 */
	public float getAlpha() {
		return alpha;
	}

}