
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public class Monitor extends Hardware {
	public double screenSize;

	// Getters
	public double getScreenSize() {
		return screenSize;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight("Screen size: " + String.valueOf(screenSize), 20);
	}

	// Setters
	public void setScreenSize(double ss) {
		screenSize = ss;
	}
}
