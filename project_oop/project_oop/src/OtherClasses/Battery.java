package OtherClasses;

import java.util.Scanner;

public class Battery {

	private int kWh, chargeDuration;
	

	public Battery(int kWh, int chargeDuration) {
		this.kWh = kWh;
		this.chargeDuration = chargeDuration;
	}
	
	public int getkWh() {
		return kWh;
	}

	public void setkWh(int kWh) {
		this.kWh = kWh;
	}

	public int getChargeDuration() {
		return chargeDuration;
	}

	public void setChargeDuration(int chargeDuration) {
		this.chargeDuration = chargeDuration;
	}

	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter kWh:");
		kWh = scanner.nextInt();
		
		System.out.println("Enter charge duration:");
		chargeDuration = scanner.nextInt();
	}

	@Override
	public String toString() {
		return "\n\tBattery" + "\n\tkWh=" + kWh + "\n\tchargeDuration=" + chargeDuration;
	}
	
}
