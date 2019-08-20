
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

public abstract class Component {

	public String sku;
	public String manufacturer;
	public String name;
	public double price;

	// Getters
	public String getSku() {
		return sku;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getFullInfo() {
		return padRight(String.valueOf(sku), 9) + padRight(name, 25) + padRight(String.valueOf(price), 10)
				+ padRight(manufacturer, 15);
	}

	// Setters
	public void setSku(String s) {
		sku = s;
	}

	public void setManufacturer(String m) {
		manufacturer = m;
	}

	public void setName(String n) {
		name = n;
	}

	public void setPrice(double p) {
		price = p;
	}

	public String padRight(String s, int n) {
		return String.format("%-" + n + "s", s);
	}
}
