package assignment8;

import processing.core.PApplet;

public class Disk2 extends Disk {
	
	protected int numOfCalls = 0;
	protected int direction = -1;
	 static int numOfDisks = 0;
	 
	public Disk2(PApplet canvas) {
		super(canvas);
		numOfDisks++;
		
		rx = canvas.random(50, 100 );
		ry = rx;
		
		alpha = canvas.random(255);
		direction = direction * (int)canvas.random(8);
	}
	
	
	
	public void change ( ) {
		
		//adjust the color settings
		numOfCalls++;
		if (numOfCalls > 1 && alpha > 0 && alpha <255) {
			alpha = alpha + direction;
			numOfCalls = 0;
		}
		else if (alpha <= 0 || alpha >= 255 ) { 
			direction = direction*(-1);
			alpha = alpha + direction;
		}
		
		col = canvas.color(red, green, blue, alpha);
		canvas.fill(col);
		canvas.stroke(col);
		// call the ellipse method on the PApplet object to draw
		// this object to the canvas
		this.canvas.ellipse(x, y, rx, ry);
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
	}
	

}
