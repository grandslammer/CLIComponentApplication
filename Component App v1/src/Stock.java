
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

import java.util.ArrayList;

public class Stock {
	static ArrayList<Component> componentList = new ArrayList<>();

	public static ArrayList<Component> loadAllStock() {
		Operating_System os1 = new Operating_System();
		os1.setManufacturer("Microsoft");
		os1.setOsName("Windows 10");
		os1.setPrice(130);
		os1.setSku(10001);
		os1.setVersion("version 1.0");
		os1.setName("operating software");

		Operating_System os2 = new Operating_System();
		os2.setManufacturer("Microsoft");
		os2.setOsName("Windows 8");
		os2.setPrice(110);
		os2.setSku(10002);
		os2.setVersion("version 1.1");
		os2.setName("operating software");

		Game g1 = new Game();
		g1.setManufacturer("Activision");
		g1.setName("Call of Duty");
		g1.setPrice(60);
		;
		g1.setSku(10003);
		g1.setAgeRating(18);
		g1.setVersion("version 1.1");

		Application ap1 = new Application();
		ap1.setManufacturer("microsoft");
		ap1.setName("Excel");
		ap1.setPrice(110);
		ap1.setSku(10004);
		ap1.setFileSize(250);
		ap1.setVersion("version 1.5");
		ap1.setFileSize(1.2);

		Monitor m1 = new Monitor();
		m1.setManufacturer("Fujitsu");
		m1.setPrice(110);
		m1.setName("monitor");
		m1.setScreenSize(27);
		m1.setSku(10005);
		m1.setWeight(1.0);

		Keyboard k1 = new Keyboard();
		k1.setManufacturer("Logitech");
		k1.setName("keyboard");
		k1.setPrice(110.0);
		k1.setQwerty(true);
		k1.setSku(10006);
		k1.setWeight(5);

		Monitor m2 = new Monitor();
		m2.setName("monitor");
		m2.setPrice(115.0);
		m2.setManufacturer("HP");
		m2.setWeight(1.5);
		m2.setScreenSize(32);
		m2.setSku(10007);

		Monitor m3 = new Monitor();
		m3.setName("monitor");
		m3.setPrice(120.0);
		m3.setManufacturer("ASUS");
		m3.setWeight(2.0);
		m3.setScreenSize(40);
		m3.setSku(10008);

		componentList.add(os1);
		componentList.add(os2);
		componentList.add(g1);
		componentList.add(ap1);
		componentList.add(m1);
		componentList.add(k1);
		componentList.add(m2);
		componentList.add(m3);

		return componentList;
	}
}
