package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

	CabInvoiceGenerator invoiceGenerator;

	@Before
	public void init() {
		invoiceGenerator = new CabInvoiceGenerator();
	}

	// To test total fare for a given userId for premium and normal types
	@Test
	public void givenUserIDRidesShouldReturnInvoiceSummary() {
		List<Ride> rides = new ArrayList<>();
		rides.add(new Ride(5, 10, "premium"));
		rides.add(new Ride(0.1, 2, "normal"));
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides("abc1", rides);
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareMultipleRides(rideRepository.getRides("abc1"));
		InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(2, 100);
		Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
	}

}
