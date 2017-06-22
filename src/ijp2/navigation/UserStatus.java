package ijp2.navigation;

import ijp2.other.Item;

public class UserStatus extends Status{
	
	Position position;
	Item standByItem;

	public UserStatus(Position position, Item standByItem) {
		this.position = position;
		this.standByItem = standByItem;
	}

	public Item getStandByItem() {
		return standByItem;
	}

	public void setStandByItem(Item standByItem) {
		this.standByItem = standByItem;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
