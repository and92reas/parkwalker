package ijp2.repository;



import java.util.HashMap;

import ijp2.navigation.Direction;
import ijp2.navigation.Location;
import ijp2.navigation.Move;
import ijp2.navigation.Position;
import ijp2.other.Item;
import ijp2.other.ItemPicture;
import ijp2.other.LocationPicture;
import ijp2.other.MapPicture;
import ijp2.other.Params;
import ijp2.other.Picture;

public class Repository{
	
	private HashMap<Position,Picture> allLocations;
	private HashMap<Integer,Item> allItems;
	private HashMap<Integer,Picture> allMap;
	
	
	
	public Repository() {
		allLocations = new HashMap<Position,Picture>();
		allItems = new HashMap<Integer,Item>();
		allMap = new HashMap<Integer,Picture>();
		String pictureURL = "/Locations/";
	    String typeOfImage = ".jpg";
	    for (int loc=0; loc<Params.LOCATIONS.length; loc++) {
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.FORWARD_CODE),new Move(Params.DOWN_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + "Forwarddown" + 
	    			(loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.FORWARD_CODE] + "_" + Params.MOVES[Params.DOWN_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.FORWARD_CODE),new Move(Params.STRAIGHT_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL 
	    			+ "Forward" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.FORWARD_CODE] + "_" + Params.MOVES[Params.STRAIGHT_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.FORWARD_CODE),new Move(Params.UP_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL +
	    			"Forwardup" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.FORWARD_CODE] + "_" + Params.MOVES[Params.UP_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.RIGHTWARDS_CODE),new Move(Params.DOWN_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + "Rightdown" + (loc+1) + 
	    			typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.RIGHTWARDS_CODE] + "_" + Params.MOVES[Params.DOWN_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.RIGHTWARDS_CODE),new Move(Params.STRAIGHT_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Right" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.RIGHTWARDS_CODE] + "_" + Params.MOVES[Params.STRAIGHT_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.RIGHTWARDS_CODE),new Move(Params.UP_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Rightup" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.RIGHTWARDS_CODE] + "_" + Params.MOVES[Params.UP_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.BACKWARDS_CODE),new Move(Params.DOWN_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Backdown" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.BACKWARDS_CODE] + "_" + Params.MOVES[Params.DOWN_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.BACKWARDS_CODE),new Move(Params.STRAIGHT_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Back" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.BACKWARDS_CODE] + "_" + Params.MOVES[Params.STRAIGHT_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.BACKWARDS_CODE),new Move(Params.UP_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Backup" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.BACKWARDS_CODE] + "_" + Params.MOVES[Params.UP_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.LEFTWARDS_CODE),new Move(Params.DOWN_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Leftdown" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.LEFTWARDS_CODE] + "_" + Params.MOVES[Params.DOWN_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.LEFTWARDS_CODE),new Move(Params.STRAIGHT_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Left" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.LEFTWARDS_CODE] + "_" + Params.MOVES[Params.STRAIGHT_CODE]));
	    	allLocations.put(new Position(new Location(loc),new Direction(Params.LEFTWARDS_CODE),new Move(Params.UP_CODE)),
	    			new LocationPicture(this.getClass().getResource(pictureURL + 
	    			"Leftup" + (loc+1) + typeOfImage).toString(),Params.LOCATIONS[loc] +"_" + Params.DIRECTIONS[Params.LEFTWARDS_CODE] + "_" + Params.MOVES[Params.UP_CODE]));
	    }
	    pictureURL = "/Map/";
	    typeOfImage = ".png";
	    for (int park=0; park<Params.PARK.length; park++) {
	    	allMap.put(park,new MapPicture(this.getClass().getResource(pictureURL + "park" + park + typeOfImage).toString(),Params.PARK[park]));
	    }
	    pictureURL = "/Items/";
	    typeOfImage = ".png";
	    allItems.put(Params.FOOTBALL_INDEX,new Item(Params.FOOTBALL_INDEX,new ItemPicture(this.getClass().getResource(pictureURL + "football" + typeOfImage).toString(),Params.FOOTBALL_ITEM)));
	    allItems.put(Params.FRUIT_INDEX,new Item(Params.FRUIT_INDEX,new ItemPicture(this.getClass().getResource(pictureURL + "fruit" + typeOfImage).toString(),Params.FRUIT_ITEM)));
	    allItems.put(Params.SQUIRRELL_INDEX,new Item(Params.SQUIRRELL_INDEX,new ItemPicture(this.getClass().getResource(pictureURL + "squirrel" + typeOfImage).toString(),Params.SQUIRREL_ITEM)));
	    
	}
	

	public Picture selectLocationPicture(Position info) {
		
		return allLocations.get(info);
	}
	
	public Item selectItemPicture(Integer itemIndex) {
		return allItems.get(itemIndex);
	}
	
	public Picture selectMapPicture(Integer mapIndex) {
		return allMap.get(mapIndex);
	}

}
