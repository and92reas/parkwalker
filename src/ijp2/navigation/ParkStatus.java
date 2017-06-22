package ijp2.navigation;

import java.util.HashMap;

import ijp2.other.Item;

public class ParkStatus extends Status{
	
	private HashMap<Integer,Item> locationsWithItems;
	
	
	public ParkStatus() {
		locationsWithItems = new HashMap<Integer,Item>();
	}


	public HashMap<Integer, Item> getLocationsWithItems() {
		return locationsWithItems;
	}


	public void setLocationsWithItems(HashMap<Integer, Item> locationsWithItems) {
		this.locationsWithItems = locationsWithItems;
	}


	
	
	
	
	
	
	
}
