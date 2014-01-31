package navigationGraph;

import dataStructure.Edge;

public class NavEdge extends Edge {
	
	protected double cost;
	
	public NavEdge(String from, String to) {
		super(from, to);
		// TODO Auto-generated constructor stub
	}

	public NavEdge(String from, String to, double cost) {
		super(from, to);
		this.cost = cost;
	}

	

	protected double getCost() {
		return cost;
	}

	protected void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "NavEdge [cost=" + cost + "]";
	}

}
