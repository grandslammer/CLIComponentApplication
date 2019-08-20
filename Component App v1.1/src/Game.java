
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public class Game extends Software {
	public int ageRating;

	// Getters
	public int getAgeRating() {
		return ageRating;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight("Age rating: " + String.valueOf(ageRating), 20);
	}

	// Setters
	public void setAgeRating(int ar) {
		ageRating = ar;
	}
}
