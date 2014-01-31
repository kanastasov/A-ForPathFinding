package navigationGraph;

import java.util.List;
import java.util.Map;

import dataStructure.Graph;

public class NavGraph extends Graph
{

	
	public NavGraph(List nodeList, List edgeList, Map adjacency,
			boolean isDirectedGraph) {
		super(nodeList, edgeList, adjacency, isDirectedGraph);
		// TODO Auto-generated constructor stub
	}

	public void addConnection(String firstId, String secondId){
        NavNode node1 = this.getNode(firstId);
        NavNode node2 = this.getNode(secondId);
        if(node1 != null && node2 != null){
            double cost = this.calcManhattanDistance(node1, node2);
            NavEdge edge1 = new NavEdge(firstId, secondId, cost);
            NavEdge edge2 = new NavEdge(secondId, firstId, cost);
            this.addEdge(edge1);
            this.addEdge(edge2);
        }
    }

    public void removeConnection(String firstId, String secondId){
        NavEdge edge1 = new NavEdge(firstId, secondId);
        NavEdge edge2 = new NavEdge(secondId, firstId);
        this.removeEdge(edge1);
        this.removeEdge(edge2);
    }

    public double calcManhattanDistance(NavNode a, NavNode b){
        return abs(a.getPosition().getX() - b.getPosition().getX())
                + abs(a.getPosition().getY() - b.getPosition().getY());
    }
	
	
	
	
}
