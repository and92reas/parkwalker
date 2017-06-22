package ijp2.other;

public class LocationPicture extends Picture{
	
	String relativePos;
	
	public LocationPicture(String source, String relativePos) {
		super(source);
		this.relativePos = relativePos;
	}

	public String getRelativePos() {
		return relativePos;
	}

	public void setRelativePos(String relativePos) {
		this.relativePos = relativePos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((relativePos == null) ? 0 : relativePos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationPicture other = (LocationPicture) obj;
		if (relativePos == null) {
			if (other.relativePos != null)
				return false;
		} else if (!relativePos.equals(other.relativePos))
			return false;
		return true;
	}
	
	

}
