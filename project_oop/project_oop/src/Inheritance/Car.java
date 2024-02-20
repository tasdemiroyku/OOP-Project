package Inheritance;

import java.util.Scanner;

public class Car extends Vehicle{

	private String fuelType;

	
	public Car(String brand, int id, int numOfDoors, int rentDuration, String fuelType) {
		super(brand, id, numOfDoors, rentDuration);
		// TODO Auto-generated constructor stub
		this.fuelType = fuelType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public void addVat() {
		// TODO Auto-generated method stub
 		this.price = this.price * 1.18;
	}

	@Override
	public void discount() {
		// TODO Auto-generated method stub
		if(fuelType.equalsIgnoreCase("Fuel"))
		{
			price = price * 0.9;
		}
		else
		{
			price = price * 0.95;
		}
	}

	@Override
	public double getSale() {
		// TODO Auto-generated method stub
		if(rentDuration > 7)
		{
			return BASE_FEE;
		}
		return 0;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		super.getInput();
		
		scanner.skip("\\R");
		System.out.println("Enter fuel type:");
		fuelType = scanner.nextLine();
	}

	@Override
	public String toString() {
		return "\nCar" + super.toString() + 
				"\nFuel type = " + fuelType;
	}

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return id - o.getId();
	}
	
}
