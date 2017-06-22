package ijp2.navigation;

import ijp2.other.Params;

public class Location extends PositionInfo{
	public Location(int code, String description) {
		super(code, description);
	}
	
	public Location(int code) {
		super(code);
		this.code = code;
		this.description = Params.LOCATIONS[code];
	}

	@Override
	public void setCode(int code) {
		this.code = code;
		this.description = Params.LOCATIONS[code];
	}
	
	
	
	
	
	
}
