package ijp2.navigation;

import ijp2.other.Params;

public class Direction extends PositionInfo{

	public Direction(int code, String description) {
		super(code, description);
	}
	
	public Direction(int code) {
		super(code);
		this.code = code;
		this.description = Params.DIRECTIONS[code];
	}

	@Override
	public void setCode(int code) {
		this.code = code;
		this.description = Params.DIRECTIONS[code];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
