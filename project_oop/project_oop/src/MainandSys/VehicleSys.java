package MainandSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import Inheritance.Car;
import Inheritance.ElectricCar;
import Inheritance.Vehicle;

public class VehicleSys {

	private static ArrayList<Vehicle> availableCars = new ArrayList();
	private static TreeSet<Vehicle> ts;
	
	
	public static boolean readFromFile() throws FileNotFoundException {
		File file = new File("Vehicles.txt");
		
		Scanner input = new Scanner(file);
		
		if(!file.exists())
		{
			input.close();
			return false;
		}
		
		
		String type, brand, fuelType;
		int id, numOfDoors, rentDuration, range, kWh, chargeDuration;
		Vehicle temp;
		while(input.hasNext())
		{
			type=input.next();
			brand=input.next();
			id=input.nextInt();
			numOfDoors=input.nextInt();
			rentDuration=input.nextInt();
			if(type.equalsIgnoreCase("Car"))
			{
				fuelType=input.next();
				temp = new Car(brand, id, numOfDoors, rentDuration, fuelType);
				availableCars.add(temp);
			}
			else
			{
				range=input.nextInt();
				kWh=input.nextInt();
				chargeDuration=input.nextInt();
				temp = new ElectricCar(brand, id, numOfDoors, rentDuration, range, kWh, chargeDuration);
				availableCars.add(temp);
			}
		}
		input.close();
		return true;
	}
	
	
	public static boolean addVehicle(Vehicle V) {
		Vehicle temp = searchVehicle(V.getId());
		
		if(temp == null)
		{
			/*if(V instanceof Car)
			{
				availableCars.add(temp);
			}
			else
			{
				availableCars.add(temp);
			}*/
			availableCars.add(V);
			//System.out.println(temp.toString());
			return true;
		}
		return false;
	}
	
	public static String display() {
		String out = "";
		
		for(Vehicle V : availableCars)
		{
			out += V.toString() + "\n";
		}
		
		return out;
	}
	
	public static Vehicle searchVehicle(int id) {
		for(Vehicle V : availableCars) {
			if(V.getId() == id)
			{
				return V;
			}
		}
		return null;
	}
	
	
	
	public static double calculateFee(Vehicle V) {
		
		if(V instanceof Car)
		{
			V.setPrice();
			V.addVat();
			V.discount();
			V.setTotal(V.getPrice()-V.getSale());
		}
		else
		{
			V.setPrice();
			V.addVat();
			V.discount();
			V.setTotal(V.getPrice()-V.getSale());
		}
		
		return V.getPrice();
	}
	
	public static boolean deleteVehicle(int id) {
		Vehicle temp;
		for(int i=0;i<availableCars.size();i++)
		{
			temp = availableCars.get(i);
			if(temp.getId()==id)
			{
				availableCars.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static String getCarsByID()
	{
		ts = new TreeSet<Vehicle>();
		
		ts.addAll(availableCars);
		
		String out = "";
		
		for(Vehicle V : ts)
		{
			out += V.toString() + "\n\n";
		}
		
		return out;
	}
	
	public static ArrayList<Vehicle> getCars()
	{
		return availableCars;
	}
	
}
