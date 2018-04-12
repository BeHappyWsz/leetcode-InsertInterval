package intertInterval;

public class Interval {
	
	int start, end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
	
}
