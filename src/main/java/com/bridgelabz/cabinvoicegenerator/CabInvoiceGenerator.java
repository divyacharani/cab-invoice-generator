package com.bridgelabz.cabinvoicegenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoiceGenerator {

	private static final double MINIMUM_COST_PER_KM_NORMAL_RIDE = 10.0;
	private static final int COST_PER_MINUTE_NORMAL_RIDE = 1;
	private static final double MINIMUM_FARE_NORMAL_RIDE = 5.0;
	private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15.0;
	private static final int COST_PER_MINUTE_PREMIUM_RIDE = 2;
	private static final double MINIMUM_FARE_PREMIUM_RIDE = 20.0;

	private static final Logger LOG = LogManager.getLogger(CabInvoiceGenerator.class);

	public static void main(String[] args) {

		// Welcome Message
		LOG.info("Welcome to Cab Invoice Generator Program");
	}

	// To calculate fare
	public double calculateFare(double distance, int time, String rideType) {
		double totalFare = 0;
		if (rideType.equalsIgnoreCase("normal")) {
			totalFare = distance * MINIMUM_COST_PER_KM_NORMAL_RIDE + time * COST_PER_MINUTE_NORMAL_RIDE;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL_RIDE);
		}
		if (rideType.equalsIgnoreCase("premium")) {
			totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_MINUTE_PREMIUM_RIDE;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM_RIDE);
		}
		return totalFare;
	}

	// To calculate fare for multiple rides
	public InvoiceSummary calculateFareMultipleRides(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.getDistance(), ride.getTime(), ride.getType());
		return new InvoiceSummary(rides.length, totalFare);
	}

}
