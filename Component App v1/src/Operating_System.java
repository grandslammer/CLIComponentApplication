
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public class Operating_System extends Software {
	public String osName;

	// Getters
	public String getOsName() {
		return osName;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight(osName, 20);
	}

	// Setters
	public void setOsName(String osn) {
		osName = osn;
	}
}
