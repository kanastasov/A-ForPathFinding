package aStarSearchAlgo;

import java.util.Comparator;

/**
 * and a comparator for Java priority queue.
 * @author ForexMaster
 *
 */

public class AStarNodeComparator implements Comparator<AStarNode> {

    public int compare(AStarNode first, AStarNode second) {
        if(first.getF() < second.getF()){
            return -1;
        }else if(first.getF() > second.getF()){
            return 1;
        }else{
            return 0;
        }
    }
}