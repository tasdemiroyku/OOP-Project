package Inheritance;

import java.util.Scanner;

import OtherClasses.VehicleInterface;

public abstract class Vehicle implements VehicleInterface, Comparable<Vehicle>{

	protected String brand;
	protected int id, numOfDoors, rentDuration;
	protected static final double BASE_FEE = 100;
	protected double price;
	
	
	public Vehicle(String brand, int id, int numOfDoors, int rentDuration) {
		this.brand = brand;
		this.id = id;
		this.numOfDoors = numOfDoors;
		this.rentDuration = rentDuration;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice() {
		this.price=BASE_FEE * rentDuration;
	}
	
	public void setTotal(double p) {
		this.price=p;
	}
	
	public double getBASE_FEE() {
		return BASE_FEE;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public abstract double getSale();

	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter brand:");
		brand = scanner.nextLine();
		
		System.out.println("Enter id:");
		id = scanner.nextInt();
		
		System.out.println("Enter number of doors:");
		numOfDoors = scanner.nextInt();
		
		System.out.println("Enter rent duration:");
		rentDuration = scanner.nextInt();
	}
	
	@Override
	public String toString() {
		return "\nBrand = " + brand +
				"\nId = " + id + 
				"\nNumber of Doors = " + numOfDoors;
	}
	
}
