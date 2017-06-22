package ijp2.navigation;

public abstract class PositionInfo {
	protected int code;
	protected String description;
	
	public PositionInfo(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public PositionInfo(int code) {} //practically an abstract constructor

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract void setCode(int code);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionInfo other = (PositionInfo) obj;
		if (code != other.code)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	
}
