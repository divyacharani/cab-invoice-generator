package com.bridgelabz.cabinvoicegenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoiceGenerator {

	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	private static final Logger LOG = LogManager.getLogger(CabInvoiceGenerator.class);

	public static void main(String[] args) {

		// Welcome Message
		LOG.info("Welcome to Cab Invoice Generator Program");
	}

	// To calculate fare
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}

	// To calculate fare for multiple rides
	public double calculateFareMultipleRides(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.distance, ride.time);
		return totalFare;
	}

}
