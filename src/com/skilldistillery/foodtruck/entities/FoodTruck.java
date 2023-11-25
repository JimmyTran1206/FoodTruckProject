package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	// fields- private
	private String name;
	private String foodType;
	private int rating;
	
	// field getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	// full constructor
	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	
	// empty constructor
	public FoodTruck() {
		
	}
	
	// toString
	public String toString() {
		return "Food truck " + name + " is selling " + foodType + " with the rating of " + rating + ".";
	}
	
}
