package dataStructure;
/**Adjecency is used to represent the neighbours of the current node.
 * 
 */
import java.util.Set;

public class Adjacency<N extends Node> 
{
	protected N node;
	
	protected Set<N> neighbors;

	public Adjacency(N node, Set<N> neighbors) {
		super();
		this.node = node;
		this.neighbors = neighbors;
	}

	protected N getNode() {
		return node;
	}

	protected void setNode(N node) {
		this.node = node;
	}

	protected Set<N> getNeighbors() {
		return neighbors;
	}

	protected void setNeighbors(Set<N> neighbors) {
		this.neighbors = neighbors;
	}


	
	@Override
	public String toString() {
		return "Adjacency [node=" + node + ", neighbors=" + neighbors + "]";
	}
}
