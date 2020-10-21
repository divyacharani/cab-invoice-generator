package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

	CabInvoiceGenerator invoiceGenerator;

	@Before
	public void init() {
		invoiceGenerator = new CabInvoiceGenerator();
	}

	// To test total fare when greater than minimum fare
	@Test
	public void givenDistanceTimeShouldReturnTotalFare() {

		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double totalFare = invoiceGenerator.calculateFare(5, 10);
		Assert.assertEquals(60, totalFare, 0.0);
	}

	// To test total fare when less than minimum fare
	@Test
	public void givenDistanceTimeWhenLessThanMinimumFareShouldReturnMinimumFare() {

		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double totalFare = invoiceGenerator.calculateFare(0.1, 2);
		Assert.assertEquals(5, totalFare, 0.0);
	}

	// To test total fare for multiple rides
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(5, 10), new Ride(0.1, 2) };
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareMultipleRides(rides);
		InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(2, 65);
		Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
	}
	
	//To test total fare for a given userId
	@Test
	public void givenUserIDRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(5, 10), new Ride(0.1, 2) };
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides("abc1", rides);
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareMultipleRides(rideRepository.getRides("abc1"));
		InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(2, 65);
		Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
	}

}
