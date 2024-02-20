package Inheritance;

import java.util.Scanner;

import OtherClasses.Battery;

public class ElectricCar extends Vehicle{
	
	private Battery battery;
	private int range;
	
	
	public ElectricCar(String brand, int id, int numOfDoors, int rentDuration, int range, int kWh, int chargeDuration) {
		super(brand, id, numOfDoors, rentDuration);
		// TODO Auto-generated constructor stub
		battery = new Battery(kWh, chargeDuration);
		this.range = range;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public void addVat() {
		// TODO Auto-generated method stub
		this.price = this.price * 1.18;
	}

	@Override
	public void discount() {
		// TODO Auto-generated method stub
		price = price * 0.7;
	}

	@Override
	public double getSale() {
		// TODO Auto-generated method stub
		if(rentDuration > 7)
		{
			return BASE_FEE * 1.5;
		}
		return 0;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		super.getInput();
	
		battery.getInput();
		
		System.out.println("Enter range:");
		range = scanner.nextInt();
	}

	@Override
	public String toString() {
		return "\nElectric Car" + super.toString() + 
				"\nRange = " + range +
				  battery.toString();
				
	}

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return id - o.getId();
	}

	
}
