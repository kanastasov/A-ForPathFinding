package dataStructure;

public class Edge 
{

	protected String from;
	
	protected String to;

	public Edge(String from, String to) 
	{
		super();
		this.from = from;
		this.to = to;
	}

	protected String getFrom() {
		return from;
	}

	protected void setFrom(String from) {
		this.from = from;
	}

	protected String getTo() {
		return to;
	}

	protected void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + "]";
	}
	
	
	
	
}
