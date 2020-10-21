package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	private double distance;
	private int time;

	// Constructor
	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	// Setter and Getter
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
