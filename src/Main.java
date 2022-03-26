// Main.java - holds code to run program
// Stacey Popenfoose
// CSIS 212 001

import java.text.DecimalFormat;
import java.util.Scanner;

// 1.	Store the parameters (number of chickens, eggs laid per day, etc.,) in static fields of the class.
//2.	Have separate methods for updating the parameters.
//3.	Use a switch statement to take menu selections for updating parameters or outputting results.
//4.	If the menu choice is 0, the program should terminate, invalid inputs should be ignored and any prompt repeated.
//5.	Before displaying updated menu, “clear the screen”


public class Main {
	// create scanner here so that all methods can access it
	public static Scanner inputObj = new Scanner(System.in);
	public static DecimalFormat decFormat = new DecimalFormat("0.00"); // set decimal format
	// static variables
	static int chickens = 0;
	static double eggsPerHen = 0.0;
	static double feedCostPerLb = 0.0;
	static double LbsFeedPerHenPerDay = 0.0;
	static double cartonCost = 0.0;
	// methods for updating parameters
	public static void updateChickens() {
		// display current number
		System.out.println("Current number of chickens: " + chickens);
		// prompt user for updated number
		System.out.print("New number of chickens: ");
		// update variable with user input
		chickens = inputObj.nextInt();
	}
	public static void updateEggsPerHen() {
		System.out.println("Current eggs per hen: " + eggsPerHen);
		System.out.print("New number of eggs per hen: ");
		eggsPerHen = inputObj.nextDouble();
	}
	public static void updateFeedCostPerLb() {
		System.out.println("Current cost of feed per lb: $" + feedCostPerLb);
		System.out.print("New cost per lb: $");
		feedCostPerLb = inputObj.nextDouble();
	}
	public static void updateLbsPerHenPerDay() {
		System.out.println("Current lbs of feed per hen per day: " + LbsFeedPerHenPerDay);
		System.out.print("New lbs per hen per day: ");
		LbsFeedPerHenPerDay = inputObj.nextDouble();
	}
	public static void updateCartonCost() {
		System.out.println("Current carton cost: $" + cartonCost);
		System.out.print("New carton cost: $");
		cartonCost = inputObj.nextDouble();
	}
	public static void updatedNumbers() {
		System.out.println("\n\n\nNumber of chickens: " + chickens);
		System.out.println("Eggs per hen: " + eggsPerHen);
		System.out.println("Cost of feed per lb: $" + feedCostPerLb);
		System.out.println("Lbs of feed per hen per day: " + LbsFeedPerHenPerDay);
		System.out.println("Cost per carton: $" + cartonCost);
	}
	public static void showTotals() {
		double eggsPerMonth = chickens*eggsPerHen*30;
		System.out.println("Eggs Per Month: " + decFormat.format(eggsPerMonth));
		double feedPerMonth = LbsFeedPerHenPerDay*chickens*30;
		System.out.println("Feed Total Cost: $" + decFormat.format(feedPerMonth));
		double dozenEggs = eggsPerMonth/12;
		double cartonPerMonth = dozenEggs*cartonCost;
		System.out.println("Cartons Total Cost: $" + decFormat.format(cartonPerMonth));
		double totalPerMonth = feedPerMonth + cartonPerMonth;
		System.out.print("It costs $" + decFormat.format(totalPerMonth));
		System.out.printf(" to produce %f dozen eggs\n", dozenEggs);
		double costPerDozen = totalPerMonth/dozenEggs;
		System.out.println("Operating cost per dozen: $" + decFormat.format(costPerDozen));
	}
	public static void main(String[] args) {
		// print menu to user
		System.out.println("Menu");
		System.out.print("1. Update Number of Chickens\n2. Update Eggs per Hen\n3. "
				+ "Update Feed Cost per Pound\n4. Update Lbs. of Feed per Hen per Day\n"
				+ "5. Update Egg Carton Cost\n6. Show Totals\n0. Exit\n");
		// prompt for user selection
		System.out.print("Enter your menu selection number: ");		
		// store user selection as variable
		int userSelect = inputObj.nextInt();
		// while loop continuously prompts for new input if not valid
		while (userSelect != 0 && userSelect != 1 && userSelect != 2 &&
				userSelect != 3 && userSelect != 4 && userSelect != 5 &&
				userSelect != 6) {
			System.out.println("Please enter a selection between 0 and 6");
			System.out.print("Enter your menu selection number: ");		
			userSelect = inputObj.nextInt();
		}
		while (userSelect != 0) { // allow menu selections until user wants to exit
			switch(userSelect) { 	// switch statement to act on menu selection
				case 1:
					// call method to update chickens
					updateChickens(); 
					break;
				case 2:
					// call method to update eggs per hen
					updateEggsPerHen();
					break;
				case 3:
					// call method to update feed cost per lb
					updateFeedCostPerLb();
					break;
				case 4:
					// call method to update lbs of feed per hen per day
					updateLbsPerHenPerDay();
					break;
				case 5:
					// call method to update egg carton cost
					updateCartonCost();
					break;
				case 6:
					// call method to show totals
					showTotals();
					break;
			}
			// display updated numbers to user
			updatedNumbers();
			// print menu and get user selection again for each time loop runs
			System.out.print("\n\n\n\n\n\n\n\n"); // "clear" screen 
			System.out.println("Menu");
			System.out.print("1. Update Number of Chickens\n2. Update Eggs per Hen\n3. "
					+ "Update Feed Cost per Pound\n4. Update Lbs. of Feed per Hen per Day\n"
					+ "5. Update Egg Carton Cost\n6. Show Totals\n0. Exit\n");
			System.out.print("Enter your menu selection number: ");
			userSelect = inputObj.nextInt();
			while (userSelect != 0 && userSelect != 1 && userSelect != 2 &&
					userSelect != 3 && userSelect != 4 && userSelect != 5 &&
					userSelect != 6) {
				System.out.println("Please enter a selection between 0 and 6");
				System.out.print("Enter your menu selection number: ");		
				userSelect = inputObj.nextInt();
			}
		}
		// when user enters 0, while loop will end and execute subsequent code
		// exit program
		System.out.println("Exiting program. Goodbye!");
		inputObj.close(); // close scanner
	}
}
