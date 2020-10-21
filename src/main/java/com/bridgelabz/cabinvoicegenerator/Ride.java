package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	private double distance;
	private int time;
	private String type;

	// Constructor
	public Ride(double distance, int time, String type) {
		this.distance = distance;
		this.time = time;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
