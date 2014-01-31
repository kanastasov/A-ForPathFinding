package dataStructure;
/**A Graph can be defined as follow. the edgeList and adjacency may replace each other depending how you used the app.
 * 
 */

import java.util.List;
import java.util.Map;

public class Graph<N extends Node, E extends Edge>
{
	protected List<N> nodeList;
	
	protected List<E> edgeList;
	
	
	/**
	 * adjacency is index for fast access with map.
	 */
	private Map<String, Adjacency<N>> adjacency;
	
	/**
	 * isDerectedGraph is used to determine whether a graph is directed or not.
	 */
	protected boolean isDirectedGraph;

	public Graph(List<N> nodeList, List<E> edgeList,
			Map<String, Adjacency<N>> adjacency, boolean isDirectedGraph)
	{
		super();
		this.nodeList = nodeList;
		this.edgeList = edgeList;
		this.adjacency = adjacency;
		this.isDirectedGraph = isDirectedGraph;
	}

	protected List<N> getNodeList() {
		return nodeList;
	}

	protected void setNodeList(List<N> nodeList) {
		this.nodeList = nodeList;
	}

	protected List<E> getEdgeList() {
		return edgeList;
	}

	protected void setEdgeList(List<E> edgeList) {
		this.edgeList = edgeList;
	}

	protected Map<String, Adjacency<N>> getAdjacency() {
		return adjacency;
	}

	protected void setAdjacency(Map<String, Adjacency<N>> adjacency) {
		this.adjacency = adjacency;
	}

	protected boolean isDirectedGraph() {
		return isDirectedGraph;
	}

	protected void setDirectedGraph(boolean isDirectedGraph) {
		this.isDirectedGraph = isDirectedGraph;
	}

	@Override
	public String toString() {
		return "Graph [nodeList=" + nodeList + ", edgeList=" + edgeList
				+ ", adjacency=" + adjacency + ", isDirectedGraph="
				+ isDirectedGraph + "]";
	}
	
	
	
	
	
	
	
	

}
