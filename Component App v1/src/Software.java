
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public abstract class Software extends Component {
	public String version;

	// Getters
	public String getVersion() {
		return version;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight(version, 18);
	}

	// Setters
	public void setVersion(String v) {
		version = v;
	}
}
