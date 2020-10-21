package com.bridgelabz.cabinvoicegenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {

	private Map<String, List<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<>();
	}

	// To add rides to the user
	public void addRides(String userId, Ride[] rides) {
		this.userRides.put(userId, Arrays.asList(rides));
	}

	// To return rides of given userID
	public Ride[] getRides(String userId) {
		return this.userRides.get(userId).toArray(new Ride[0]);
	}
}
