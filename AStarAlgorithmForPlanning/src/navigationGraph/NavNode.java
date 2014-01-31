package navigationGraph;

/**In the warehouse application, we need to build a navigation graph to
 *  help us to construct the path for the pick agent. In a tiled environment,
 *   you can first use the Flood Fill algorithm to search for the connection 
 *   in the application world. Then build a navigation graph based on it.
 *    For our warehouse application, we can create outlines for aisles to
 *     obtain a navigation graph.
 *     
 * The navigation graph is defined as follows.
 */

import java.util.List;
import dataStructure.Node;
import dataStructure.Position;

public class NavNode extends Node
{

	protected Position position;

    protected List<String> extraData;

    
    public NavNode(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
    
    public NavNode(String id, Position position, List<String> extraData) {
		super(id);
		this.position = position;
		this.extraData = extraData;
	}

	protected Position getPosition() {
		return position;
	}

	protected void setPosition(Position position) {
		this.position = position;
	}

	protected List<String> getExtraData() {
		return extraData;
	}

	protected void setExtraData(List<String> extraData) {
		this.extraData = extraData;
	}

	@Override
	public String toString() {
		return "NavNode [position=" + position + ", extraData=" + extraData
				+ "]";
	}
    
    
    
}
