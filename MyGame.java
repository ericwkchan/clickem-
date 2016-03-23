package assignment8;

/**
 * @author Eric Chan
 * @version 11/30/2015
 */
import processing.core.PApplet;

public class MyGame extends PApplet {
	int xMax = 1500;
	int yMax = 800;
	int maxDisks = 60;
	Disk [] myDisks = new Disk [maxDisks];
	int currentNumOfDisks = 1;
	int counter = 0;
	String diskTextInside = "";
	String disappear = "";
	int totalScore = 0;
	long startTime = System.currentTimeMillis();
	long endTime = startTime + 60*1000;

	public void setup() {
//		set the size of the canvas for your "drawing:
		size(xMax,yMax);
		frameRate(60);
		background (200,200,200);

		for (int i = 0; i < myDisks.length; i++) {
			myDisks[i] = new Disk(this);
		
		}

	}
	
	public void draw() {
			// sets background color
			background (188,188,188);
			counter++;
			if (counter >= 60  && currentNumOfDisks < maxDisks) {
	
				currentNumOfDisks++;
				counter = 0;
			}
			

				//let the disks move according to their own rules
				
				for (int i = 0; i < currentNumOfDisks; i++) {
					
					myDisks[i].move();
					fill(0);
					
					textSize(15);
					textAlign(CENTER);
					
					diskTextInside = myDisks[i].getValueString();
					text(diskTextInside, myDisks[i].getXNum(), myDisks[i].getYNum());
					
					if(myDisks[i].getAlpha() == 0) {
						myDisks[i].setValueString("");
					}
					
				
				}
				// if mouse is clicked and a disk is clicked, it disappears
				if (mousePressed) {
					for (int j = 0; j < myDisks.length; j++) {
						double distance = Math.sqrt(Math.pow((myDisks[j].getXNum()-mouseX),2.0) + Math.pow((myDisks[j].getYNum()-mouseY),2.0));
						if (distance < myDisks[j].getRx()) {
							myDisks[j].setRed(188);
							myDisks[j].setGreen(188);
							myDisks[j].setBlue(188);
							myDisks[j].setValueString("");
		
							totalScore = totalScore + myDisks[j].getValue();
							myDisks[j].setValueInt(0);
						}
						
					}
					
				}
		// after 60 seconds, a game over screen with score is displayed
		if (System.currentTimeMillis() > endTime) {
			// sets everything to 0 
			for (int i = 0; i < myDisks.length; i++) {
				myDisks[i].setValueInt(0);
			}
			
			background(150,150,150);
			textAlign(CENTER);
			textSize(20);
			text("Game Over \n Your total score is: "
						+ totalScore, 750, 400);
		}

		}
	public static void main(String args[]) {
		PApplet.main(new String[] { "MyGame" });
		
	}

}

