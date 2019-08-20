
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public class Application extends Software {
	public double fileSize;

	// Getters
	public double getFileSize() {
		return fileSize;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight("File size: " + String.valueOf(fileSize) + "GB", 20);
	}

	// Setters
	public void setFileSize(double fs) {
		fileSize = fs;
	}
}
