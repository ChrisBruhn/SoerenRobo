package H23HX3;
import robocode.*;

// det hedder den ikke ! ;)
//import java.util.Math;
//https://docs.oracle.com/javase/8/docs/api/?java/lang/Math.html
import java.lang.Math;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html
/**
 * Rasmus - a robot by (your name here)
 */
public class Rasmus extends JuniorRobot
{
	/**
	 * run: Rasmus's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		// Some color codes: blue, yellow, black, white, red, pink, brown, grey, orange...
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		setColors(orange, blue, white, yellow, black);

		// Robot main loop
		while(true) {
		fire(0.1);
			// Replace the next 4 lines with any behavior you would like
		}
	}
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot() {

		// Replace the next line with any behavior you would like
		if(scannedVelocity == 0) {
			bearGunTo(0);
			fire(3);
			}

		// Matematik del - turnGunTo(mig); fire(3);
		// det er kun klassens attributter som deklarerers som private eller public
		int t = 1; // int der bruges til at bestemme tiden mht. kollision af fjende og kugle
		int xf = robotX + Math.cos(scannedAngle)*scannedDistance; // x koordinat til fjende
		int yf = robotY + sin(scannedAngle)*scannedDistance; // y koordinat til fjende
		int xc = xf + cos(scannedHeading)*scannedVelocity*t; // x koordinat til kollision med fjende og kugle efter tid t
		int yc = yf + sin(scannedHeading)*scannedVelocity*t; // y koordinat til kollision med fjende og kugle efter tid t
		
// her mangler der en parantes luk
		turnTo(Math.round(toDegrees(asin((yc-robotY)/sqrt(((xc-robotX)^2)+((yc-robotY)^2))))));
	}	
	
	public void onHitWall() {
		back(15);
		turnRight(100);
	}
}
