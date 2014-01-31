package aStarSearchAlgo;

/**
 * The algorithm is not complicated as shown in the following class.
 *  For more algorithm details, please refer to A`*` search algorithm.
 * @author ForexMaster
 *
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import navigationGraph.NavNode;
import navigationGraph.NavGraph;


public class AStarAlgorithm {
	   private static Log log = LogFactory.getLog(AStarAlgorithm.class);

	   public static List<NavNode> search(NavGraph graph, NavNode source, NavNode target) {
	        Map<String, AStarNode> openSet = new HashMap<String, AStarNode>();
	        PriorityQueue<AStarNode> pQueue = new PriorityQueue(20, new AStarNodeComparator());
	        Map<String, AStarNode> closeSet = new HashMap<String, AStarNode>();
	        AStarNode start = new AStarNode(source, 0, graph.calcManhattanDistance(source, target));
	        openSet.put(source.getId(), start);
	        pQueue.add(start);

	        AStarNode goal = null;
	        while(openSet.size() > 0){
	            AStarNode x = pQueue.poll();
	            openSet.remove(x.getId());
	            if(x.getId().equals(target.getId())){
	                //found
	                if(log.isDebugEnabled()){
	                    log.debug("Found target node " + x.getId());
	                }
	                goal = x;
	                break;
	            }else{
	                if(log.isDebugEnabled()){
	                    log.debug("Search for node " + x.getId());
	                }
	                closeSet.put(x.getId(), x);
	                Set<NavNode> neighbors = graph.getAdjacentNodes(x.getId());
	                for (NavNode neighbor : neighbors) {
	                    AStarNode visited = closeSet.get(neighbor.getId());
	                    if (visited == null) {
	                        double g = x.getG() + graph.calcManhattanDistance(x.getNode(), neighbor);
	                        AStarNode n = openSet.get(neighbor.getId());

	                        if (n == null) {
	                            //not in the open set
	                            n = new AStarNode(neighbor, g, graph.calcManhattanDistance(neighbor, target));
	                            n.setCameFrom(x);
	                            openSet.put(neighbor.getId(), n);
	                            pQueue.add(n);
	                        } else if (g < n.getG()) {
	                            //Have a better route to the current node, change its parent
	                            n.setCameFrom(x);
	                            n.setG(g);
	                            n.setH(graph.calcManhattanDistance(neighbor, target));
	                        }
	                    }
	                }
	            }
	        }

	        //after found the target, start to construct the path 
	        if(goal != null){
	            Stack<NavNode> stack = new Stack<NavNode>();
	            List<NavNode> list = new ArrayList<NavNode>();
	            stack.push(goal.getNode());
	            AStarNode parent = goal.getCameFrom();
	            while(parent != null){
	                stack.push(parent.getNode());
	                parent = parent.getCameFrom();
	            }
	            if (log.isDebugEnabled()) {
	                log.debug("Constructing search path: ");
	            }
	            while(stack.size() > 0){
	                if (log.isDebugEnabled()) {
	                    log.debug("\t" + stack.peek().getId());
	                }
	                list.add(stack.pop());
	            }
	            return list;
	        }
	        
	        return null;  
	    }
	}


/**
 * 
 * Where is NavGraphData? class defined? And which JSON library are you using?

Comment by project member John.Jian.Fang@gmail.com, Jun 2, 2010
The NavNodeDate? is application specific and it is the warehouse data in my case.

public class NavNodeData? {

private int min;
private int max;
private NavNode? node;
public NavNodeData?(){
}
public NavNodeData?(int min, int max, NavNode? node) {
this.min = min; this.max = max; this.node = node;
}
public int getMin() {
return min;
}
public void setMin(int min) {
this.min = min;
}
public int getMax() {
return max;
}
public void setMax(int max) {
this.max = max;
}
public NavNode? getNode() {
return node;
}
public void setNode(NavNode? node) {
this.node = node;
}
}

For json library, I use json_simple and stringtree-json.

Comment by zhangshu...@gmail.com, Jun 2, 2010
Thanks!

Comment by jtres...@gmail.com, Feb 26, 2011
Hi, I would like to know what is getF of your comparison method. is it the distance from source along optimal path or estimate of distance from the current node to the target node?

Thanks you

Comment by adam.nov...@gmail.com, Apr 14, 2011
getF() should return the sum of instance variables g and h.

I think.

Comment by project member John.Jian.Fang@gmail.com, Jul 7, 2011
Adam is correct.

public double getF(){
return g + h;
}
 * 
 */
*/