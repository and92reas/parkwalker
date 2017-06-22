package ijp2.navigation;

import ijp2.other.Params;

public class Move extends PositionInfo{
	
	public Move(int code, String description) {
		super(code, description);
	}
	
	public Move(int code) {
		super(code);
		this.code = code;
		this.description = Params.MOVES[code];
	}

	@Override
	public void setCode(int code) {
		this.code = code;
		this.description = Params.MOVES[code];
	}
	
	
	
	
	
	
}
