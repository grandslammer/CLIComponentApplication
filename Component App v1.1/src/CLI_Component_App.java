
// Author: Ivan White
// Software Development Course Module: Software Architecture Skills Demo
// AIS Code: 6N1449
// Date: 23rd July 2019

import java.util.ArrayList;
import java.util.Scanner;

public class CLI_Component_App {

	static ArrayList<Component> myComponentList = new ArrayList<>();

	static ArrayList<User> userList = new ArrayList<>();

	public static void main(String[] args) {
		// Loads stock
		myComponentList = Stock.loadAllStock();
		// Loads user list (only one user for now)
		userList.add(new User("test", "1234"));
		System.out.println("For testing purposes the username is: " + userList.get(0).getName());
		System.out.println("For testing purposes the password is: " + userList.get(0).getPassword());

		loginScreen();
		mainMenu();
	}

	public static int displayMenu() {
		Scanner sc = new Scanner(System.in);
		int userOption;

		System.out.println("\n/////////////////////////////////////");
		System.out.println("Main Menu");
		System.out.println("/////////////////////////////////////\n");
		System.out.println("1. View All Components");
		System.out.println("2. Select Component by SKU");
		System.out.println("3. Navigate through List of Components");
		System.out.println("4. View by Category");
		System.out.println("5. View by Sub-Category");
		System.out.println("6. Exit System\n");
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
		String skuEntered;
		do {
			System.out.println("Please enter an SKU or press Q to go back to main menu");

			skuEntered = sc.nextLine();

			// Called the checkSKU method within the if condition
			if (checkSKU(skuEntered) > -1) {
				printHeader();
				System.out.println(myComponentList.get(checkSKU(skuEntered)).getFullInfo() + "\n");
			} else {
				System.out.println("No component with that SKU found. Please try again.");
			}
		} while (!skuEntered.equalsIgnoreCase("q"));
		mainMenu();
	}

	// Checks that the SKU entered is found within the components list
	public static int checkSKU(String sku) {
		int skuIndex = -1;

		for (int i = 0; i < myComponentList.size(); i++) {
			if (sku.equalsIgnoreCase(myComponentList.get(i).getSku())) {
				skuIndex = i;
				i = myComponentList.size();
			}
		}
		return skuIndex;
	}

	public static void navigateList() {
		Scanner sc = new Scanner(System.in);
		String opt;
		int indexSelected = 0;
		int listSize = myComponentList.size() - 1;

		//Prints the header from the printHeader method
		printHeader();
		// Display first component
		System.out.println(myComponentList.get(indexSelected).getFullInfo() + "\n");

		do {
			System.out.println("1. First Component");
			System.out.println("2. Next component");
			System.out.println("3. Previous Component");
			System.out.println("4. Last Component");
			System.out.println("5. Back to Main Menu\n");
			System.out.println("Please select an option");
			opt = sc.nextLine();

			switch (opt) {
			case "1":
				indexSelected = 0;
				printHeader();
				System.out.println(myComponentList.get(0).getFullInfo() + "\n");
				break;
			case "2":
				if (indexSelected < listSize) // Goes back to start of list if last item is selected
					indexSelected++;
				else
					indexSelected = 0;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo() + "\n");
				break;
			case "3":
				if (indexSelected == 0) // Goes to end of list of first item is selected
					indexSelected = myComponentList.size() - 1;
				else
					indexSelected--;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo() + "\n");
				break;
			case "4":
				indexSelected = myComponentList.size() - 1;
				printHeader();
				System.out.println(myComponentList.get(indexSelected).getFullInfo() + "\n");
				break;
			case "5":
				mainMenu();
				break;
			default:
				System.out.println("\nPlease enter a valid option!");
				break;
			}
		} while (opt != "5");
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
			viewByCategory();
			break;
		case 5:
			viewBySubcategory();
			break;
		case 6:
			System.out.println("GOODBYE!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPlease enter a valid option!");
			break;
		}
	}

	// This method prints the labels for each column
	public static void printHeader() {
		System.out.println("SKU      Name                     Price     Manufacturer   Version/Weight    Extra Info");
		System.out.println(
				"===========================================================================================================");
	}

	public static void loginScreen() {
		Scanner sc = new Scanner(System.in);

		String nameEntered;
		String passwordEntered;
		boolean isLoggedIn = false;

		do {
			System.out.println(
					"===========================================================================================================");
			System.out.println("Login To Component App");
			System.out.println(
					"===========================================================================================================");
			System.out.println("Please enter a username:");
			nameEntered = sc.nextLine();
			System.out.println(
					"===========================================================================================================");
			System.out.println("Please enter a password:");
			passwordEntered = sc.nextLine();

			for (int i = 0; i < userList.size(); i++) {
				if (nameEntered.equals(userList.get(i).getName())
						&& passwordEntered.equals(userList.get(i).getPassword())) {
					System.out.println("\nWelcome, " + nameEntered + "\n");
					isLoggedIn = true;
				} else {
					System.out.println("Login details incorrect! Please try again");
					// Name and password hint if incorrectly entered (for testing purposes only!)
					System.out.println("Hint: " + userList.get(0).getName() + ", " + userList.get(0).getPassword());
				}
			}
		} while (isLoggedIn == false);
	}

	public static void viewByCategory() {
		Scanner sc = new Scanner(System.in);
		String optionSelected;
		do {
			System.out.println("\n\nPlease select an option\n");
			System.out.println("1. View Hardware");
			System.out.println("2. View Software");
			System.out.println("3. Return to Main Menu");

			optionSelected = sc.nextLine();

			switch (optionSelected) {
			case "1":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 1).equals("H")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "2":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 1).equals("S")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "3":
				mainMenu();
				break;
			default:
				System.out.println("\nPlease enter a valid option!");
				break;
			}
		} while (optionSelected != "3");
	}

	public static void viewBySubcategory() {
		Scanner sc = new Scanner(System.in);
		String optionSelected;

		do {
			System.out.println("\n\nPlease select an option\n");
			System.out.println("1. View Applications");
			System.out.println("2. View Games");
			System.out.println("3. View Keyboards");
			System.out.println("4. View Monitors");
			System.out.println("5. View Operating Systems");
			System.out.println("6. Return to Main Menu");

			optionSelected = sc.nextLine();

			switch (optionSelected) {
			case "1":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 3).equals("SAP")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "2":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 3).equals("SGA")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "3":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 3).equals("HKE")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "4":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 3).equals("HMO")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "5":
				printHeader();
				for (int i = 0; i < myComponentList.size(); i++) {
					String checksku = myComponentList.get(i).getSku();
					if (checksku.substring(0, 3).equals("SOS")) {
						System.out.println(myComponentList.get(i).getFullInfo());
					}
				}
				break;
			case "6":
				mainMenu();
				break;
			default:
				System.out.println("\nPlease enter a valid option!");
				break;
			}
		} while (optionSelected != "6");
	}
}
