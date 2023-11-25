package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] fleet; // array of food trucks
	private int fleetSize; // hold the actual size of the fleet
	private int MAX_SIZE=5;
	
	public static void main(String[] args) {
		FoodTruckApp foodTruckApp=new FoodTruckApp();
		foodTruckApp.run();
	}
	
	public void run() {
		// use only non static method
		Scanner keyboard= new Scanner(System.in);
		this.inputPrompt(keyboard);
		this.processUserChoice(keyboard);
	}
	
	public void inputPrompt(Scanner kb) {
		// Initiate the a temporary holder
		FoodTruck [] tempHolder = new FoodTruck[MAX_SIZE];
		
		// prompt the user to input food truck information
				
		for (int i=0; i<MAX_SIZE; i++ ) {
			System.out.print("Input food truck name: ");
			String name=kb.next();
			if (name.equals("quit")) {
				break;
			}
			System.out.print("Input food truck food style: ");
			String foodStyle=kb.next();
			System.out.print("Input food truck rating: ");
			int rating=kb.nextInt();
			System.out.println();
			FoodTruck truck=new FoodTruck(name, foodStyle,rating);
			tempHolder[i]=truck;
			fleetSize +=1;
		}
		// transfer valid inputs to the truck fleet
		fleet=new FoodTruck[fleetSize];
		for (int i=0; i<fleetSize; i++) {
			fleet[i]=tempHolder[i];
		}	
	}
	
	public void menuPrint() {
		System.out.println("================================================");
		System.out.println("|| 1. List all existing food trucks.          ||");
		System.out.println("|| 2. See the average rating of food trucks.  ||");
		System.out.println("|| 3. Display the highest rated food truck.   ||");
		System.out.println("|| 4. Quit the program.                       ||");
		System.out.println("|| Select your choice by choosing 1,2,3, or 4.||");
		System.out.println("================================================");
	}
	
	public void processUserChoice(Scanner kb) {
		String userChoice;
		while(true) {
			menuPrint();
			userChoice=kb.next();
			switch (userChoice) {
			case "1":{// print all food trucks
				if(fleetSize<=1) {
					System.out.printf("The is %d food truck in your fleet. \n", fleetSize);
				}else {
					System.out.printf("The are %d food trucks in your fleet. \n", fleetSize);				
				}
				
				for (int i=0; i<fleetSize; i++) {
					System.out.println(i+1 + ": "+ fleet[i]);
				}
				System.out.println();
				break;
			}
			case "2":{// print the average rating of all food trucks
				double averageRating=0;
				double sumRating=0;
				double singleRating=0;
				for (int i=0; i<fleetSize;i++) {
					singleRating=fleet[i].getRating();
					sumRating+=singleRating;
				}
				averageRating=sumRating/fleetSize;
				System.out.printf("The average rating of all food trucks in the fleet is %.2f. \n", averageRating);
				System.out.println();
				break;
			}
			case "3":{// print the highest rated food truck
				int highestRating=0;
				// find the highest rating
				for(FoodTruck truck:fleet) {
					if(truck.getRating()>highestRating) {
						highestRating=truck.getRating();
					} 
				}
				// print the food trucks with the highest rating, use loop in case more than one truck have a same rating
				for (FoodTruck truck:fleet) {
					if (truck.getRating()==highestRating) {
						System.out.printf("The truck %s has the highest rating of %d. \n", truck.getName(),highestRating);
					}
				}
				System.out.println();
				break;
			}
			case "4":
				System.out.println("You have chosen to quit the progrmam. \n  See you again! \n    Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please choose 1,2,3, or 4.");
				System.out.println();
				
			}
		}
		
	}

}
