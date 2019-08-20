
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public abstract class Hardware extends Component {
	public double weight;

	// Getters
	public double getWeight() {
		return weight;
	}

	public String getFullInfo() {
		return super.getFullInfo() + padRight(String.valueOf(weight) + " Kgs", 18);
	}

	// Setters
	public void setWeight(double w) {
		weight = w;
	}
}
