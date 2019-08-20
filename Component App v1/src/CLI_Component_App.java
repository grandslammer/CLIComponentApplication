
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

import java.util.ArrayList;
import java.util.Scanner;

public class CLI_Component_App {

	static ArrayList<Component> myComponentList = new ArrayList<>();

	public static void main(String[] args) {
		myComponentList = Stock.loadAllStock();
		mainMenu();
	}

	public static int displayMenu() {
		Scanner sc = new Scanner(System.in);
		int userOption;

		System.out.println("1. View All Components");
		System.out.println("2. Select Component by SKU");
		System.out.println("3. Navigate through List of Components");
		System.out.println("4. Exit System\n");
		System.out.println("Please select an option");

		userOption = sc.nextInt();

		return userOption;
	}

	public static void viewAllComponents() {
		printHeader();

		for (int i = 0; i < myComponentList.size(); i++) {
			System.out.println(myComponentList.get(i).getFullInfo());
		}
		System.out.println(
				"===========================================================================================================");
		mainMenu();
	}

	public static void selectBySKU() {
		Scanner sc = new Scanner(System.in);
		int sku;

		do {
			System.out.println("Please enter an SKU or press 0 to go back to main menu");

			sku = sc.nextInt();

			printHeader();
			for (int i = 0; i < myComponentList.size(); i++) {
				if (sku == myComponentList.get(i).getSku()) {
					System.out.println(myComponentList.get(i).getFullInfo() + "\n");
				}
			}
		} while (sku != 0);
		mainMenu();
	}

	public static void navigateList() {
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		int indexSelected = 0;

		printHeader();
		// Display first component
		System.out.println(myComponentList.get(indexSelected).getFullInfo());

		do {
			System.out.println("1. First Component");
			System.out.println("2. Next component");
			System.out.println("3. Previous Component");
			System.out.println("4. Last Component");
			System.out.println("5. Back to Main Menu\n");
			System.out.println("Please select an option");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				indexSelected = 0;
				printHeader();
				System.out.println(myComponentList.get(0).getFullInfo());
				break;
			case 2:
				indexSelected++;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo());
				break;
			case 3:
				indexSelected--;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo());
				break;
			case 4:
				indexSelected = myComponentList.size() - 1;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo());
			case 5:
				mainMenu();
				break;
			default:
				System.out.println("Please enter a valid option!");
				break;
			}
		} while (opt != 5);
	}

	public static void mainMenu() {
		int userOption = displayMenu();

		switch (userOption) {
		case 1:
			viewAllComponents();
			break;
		case 2:
			selectBySKU();
			break;
		case 3:
			navigateList();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid option!");
			break;
		}
	}

	public static void printHeader() {
		System.out.println("SKU      Name                     Price     Manufacturer   Version/Weight    Extra Info");
		System.out.println(
				"===========================================================================================================");
	}
}
