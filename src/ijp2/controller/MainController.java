package ijp2.controller;

import ijp2.view.MainView;

import ijp2.navigation.Direction;
import ijp2.navigation.Location;
import ijp2.navigation.Move;
import ijp2.navigation.ParkStatus;
import ijp2.navigation.Position;
import ijp2.navigation.UserStatus;
import ijp2.other.Item;
import ijp2.other.Params;
import ijp2.other.Picture;
import ijp2.repository.Repository;


public class MainController {
	
	private UserStatus userStatus;
	private ParkStatus parkStatus; 
	private MainView view;
	private Repository repository;
	


	public void startWalk(MainView view) {
		userStatus = new UserStatus(new Position(new Location(Params.LOCATION1_CODE),new Direction(Params.FORWARD_CODE),
				new Move(Params.STRAIGHT_CODE)),null);
		parkStatus = new ParkStatus();
		this.view = view;
		view.setController(this);
		repository = new Repository();
		view.start();
	}

	
	public void forward() {
		if(userStatus.getPosition().getDirection().getCode() == Params.LEFTWARDS_CODE) {
			userStatus.getPosition().getLocation().setCode(userStatus.getPosition().getLocation().getCode() + 3);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.RIGHTWARDS_CODE){
			userStatus.getPosition().getLocation().setCode(userStatus.getPosition().getLocation().getCode() - 3); 
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.FORWARD_CODE){
			userStatus.getPosition().getLocation().setCode(userStatus.getPosition().getLocation().getCode() + 1); 
		}
		else {
			userStatus.getPosition().getLocation().setCode(userStatus.getPosition().getLocation().getCode() - 1); 
		}
		
	}

	
	public void turnAround() {
		if(userStatus.getPosition().getDirection().getCode() == Params.LEFTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.RIGHTWARDS_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.RIGHTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.LEFTWARDS_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.FORWARD_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.BACKWARDS_CODE);
		}
		else {
			userStatus.getPosition().getDirection().setCode(Params.FORWARD_CODE);
		}		
	}

	
	public void turnRight() {
		if(userStatus.getPosition().getDirection().getCode() == Params.LEFTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.FORWARD_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.RIGHTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.BACKWARDS_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.FORWARD_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.RIGHTWARDS_CODE);
		}
		else {
			userStatus.getPosition().getDirection().setCode(Params.LEFTWARDS_CODE);
		}
	}

	
	public void turnLeft() {
		if(userStatus.getPosition().getDirection().getCode() == Params.LEFTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.BACKWARDS_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.RIGHTWARDS_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.FORWARD_CODE);
		}
		else if(userStatus.getPosition().getDirection().getCode() == Params.FORWARD_CODE) {
			userStatus.getPosition().getDirection().setCode(Params.LEFTWARDS_CODE);
		}
		else {
			userStatus.getPosition().getDirection().setCode(Params.RIGHTWARDS_CODE);
		}
		
	}

	
	public void lookUp() {
		userStatus.getPosition().getMove().setCode(userStatus.getPosition().getMove().getCode() + 1);
			
	}

	
	public void lookDown() {
		userStatus.getPosition().getMove().setCode(userStatus.getPosition().getMove().getCode() - 1);
	}

	
	public void selectItem(int index) {
		userStatus.setStandByItem(repository.selectItemPicture(index));		
	}

	
	public void placeItem() {
		parkStatus.getLocationsWithItems().put(userStatus.getPosition().getLocation().getCode(),userStatus.getStandByItem());
		userStatus.setStandByItem(null);
	}

	
	public void getItem() {
		userStatus.setStandByItem(parkStatus.getLocationsWithItems().remove(userStatus.getPosition().getLocation().getCode()));
	}

	
	public void disposeItem() {
		userStatus.setStandByItem(null);
	}
	
	
	
	
	
	
	
	public void updateInterfaceOnNewStatus() {
		Position currentInfo = new Position(userStatus.getPosition().getLocation(),userStatus.getPosition().getDirection()
				,userStatus.getPosition().getMove());
		//mainImage
		view.showMainImage(repository.selectLocationPicture(currentInfo));
		//placedItem
		view.showPlacedItemImage(parkStatus.getLocationsWithItems().get(currentInfo.getLocation().getCode()));		
		//standByItem
		view.showStandByItemImage(userStatus.getStandByItem());
				
		//buttons
		Boolean[] buttonStatus = new Boolean[Params.BUTTONS.length];
		for (int i=0; i<buttonStatus.length; i++) {
			buttonStatus[i] = true;
		}
		if((((userStatus.getPosition().getLocation().getCode() == Params.LOCATION3_CODE) 
				|| (userStatus.getPosition().getLocation().getCode() == Params.LOCATION6_CODE)) 
			 && (userStatus.getPosition().getDirection().getCode() == Params.FORWARD_CODE))
				
			|| 
			
			(((userStatus.getPosition().getLocation().getCode() == Params.LOCATION1_CODE) 
					|| (userStatus.getPosition().getLocation().getCode() == Params.LOCATION4_CODE)) 
					 && (userStatus.getPosition().getDirection().getCode() == Params.BACKWARDS_CODE))
			
			||
			
			(((userStatus.getPosition().getLocation().getCode() == Params.LOCATION4_CODE) || 
			(userStatus.getPosition().getLocation().getCode() == Params.LOCATION5_CODE) ||
			(userStatus.getPosition().getLocation().getCode() == Params.LOCATION6_CODE))
			&& (userStatus.getPosition().getDirection().getCode() == Params.LEFTWARDS_CODE))
			
			||
			
			(((userStatus.getPosition().getLocation().getCode() == Params.LOCATION1_CODE) || 
					(userStatus.getPosition().getLocation().getCode() == Params.LOCATION2_CODE) ||
					(userStatus.getPosition().getLocation().getCode() == Params.LOCATION3_CODE))
					&& (userStatus.getPosition().getDirection().getCode() == Params.RIGHTWARDS_CODE))) {
				buttonStatus[Params.MOVE_FORWARD_BUTTON_CODE] = false;
		}
		
		if (userStatus.getPosition().getMove().getCode() == Params.UP_CODE) {
				buttonStatus[Params.LOOK_UP_BUTTON_CODE] = false;
		}
		else if(userStatus.getPosition().getMove().getCode() == Params.DOWN_CODE) {
			buttonStatus[Params.LOOK_DOWN_BUTTON_CODE] = false;
		}
		view.disableEnableDirectionButtons(buttonStatus);
		
		
		//menu
		Boolean[] menuItemStatus = new Boolean[Params.MENU_ITEMS.length];
		for (int i=0; i<menuItemStatus.length; i++) {
			menuItemStatus[i] = true;
		}
		Boolean[] menuStatus = new Boolean[Params.MENU.length];
		for (int i=0; i<menuStatus.length; i++) {
			menuStatus[i] = true;
		}
		
		if(userStatus.getStandByItem() == null && parkStatus.getLocationsWithItems().get(currentInfo.getLocation().getCode()) == null) {
			menuStatus[Params.HANDLE_ITEM_CODE] = false;
		}
		
		boolean enabledFound = false;
		for (int item_code=Params.FOOTBALL_ITEM_CODE; item_code<=Params.SQUIRREL_ITEM_CODE; item_code++) {
			if(userStatus.getStandByItem() != null) {
				if(userStatus.getStandByItem().getPicture().getName().equals(Params.MENU_ITEMS[item_code])) {
					menuItemStatus[item_code] = false;
					continue;
				}	
			}
			for (Item item : parkStatus.getLocationsWithItems().values()) {
				if(item.getPicture().getName().equals(Params.MENU_ITEMS[item_code])) {
					menuItemStatus[item_code] = false;
					break;
				}
			}
			if(menuItemStatus[item_code]) {
				enabledFound = true;
			}
				
		}
		if(!enabledFound) {
			menuStatus[Params.CHOOSE_ITEM_CODE] = false;
		}
		
		
		if(!parkStatus.getLocationsWithItems().containsKey(currentInfo.getLocation().getCode())) {
			menuItemStatus[Params.GET_ITEM_CODE] = false;
		}
	    if(userStatus.getStandByItem() == null) {
			menuItemStatus[Params.PLACE_ITEM_CODE] = false;
			menuItemStatus[Params.DISCARD_ITEM_CODE] = false;
		}
		
		view.disableEnableMenus(menuStatus,menuItemStatus);
		
		//map
		Picture[] mapStatus = new Picture[Params.LOCATIONS.length];
		
		for (int loc=0; loc<Params.LOCATIONS.length; loc++) {
			if(loc == currentInfo.getLocation().getCode()) {
				for (int dir=0; dir<Params.DIRECTIONS.length; dir++) {
					if(dir == currentInfo.getDirection().getCode()) {
						mapStatus[loc] = repository.selectMapPicture(dir + 1); //see arrays DIRECTIONS and PARK in Params class
						break;
					}
				}
			}
			else {
				mapStatus[loc] = repository.selectMapPicture(Params.OTHER_CODE);
			}
		}
		
		view.showMap(mapStatus);
		
		
	}


		
	

}
