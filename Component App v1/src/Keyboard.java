
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public class Keyboard extends Hardware {
	public boolean qwerty;

	// Getters
	public boolean getQwerty() {
		return qwerty;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight("Qwerty = " + qwerty, 20);
	}

	// Setters
	public void setQwerty(boolean q) {
		qwerty = q;
	}
}
