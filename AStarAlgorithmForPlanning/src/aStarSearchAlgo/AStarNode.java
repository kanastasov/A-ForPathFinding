package aStarSearchAlgo;

import navigationGraph.NavNode;

/**
 * The A* Search Algorithm used for the world map is a bit different
 *  from the one used for the navigation map. The difference is in the
 *   way the algorithm to construct neighboring nodes. For a navigation graph,
 *    you can only select neighboring nodes defined in the graph,
 *     but for a world map, you can select any neighoring positions 
 *     that are accessible from the current node.

A* Search Algorithm
Before work on the A* algorithm, we need to create a wrap node as follows.
 * @author ForexMaster
 *
 */
public class AStarNode {

    private NavNode node;

    //used to construct the path after the search is done
    private AStarNode cameFrom;

    // Distance from source along optimal path
    private double g;

    // Heuristic estimate of distance from the current node to the target node
    private double h;
}