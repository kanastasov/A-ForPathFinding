package dataStructure;

/**A node is a vertex of the graph.
 * 
 * @author ForexMaster
 *
 */
public class Node
{

	protected String id;

	
	public Node(String id)
	{
		super();
		this.id = id;
	}


	protected String getId() 
	{
		return id;
	}


	protected void setId(String id) 
	{
		this.id = id;
	}


	@Override
	public String toString() 
	{
		return "Node [id=" + id + "]";
	}
	
	
	
	
}
