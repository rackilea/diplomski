import java.util.*;

public class GraphSorter {
  public static void main(String[] args) {
    int[][] graph = new int[][]{{9, 3}, {6, 4}, {3, 2}, {8, 6}, {5, 1}, {4, 9}, {2, 5} }; 
    LinkedList<int[]> myList = path(graph, 8);
    for (int[] edge : myList) {
      System.out.println(Arrays.toString(edge));
    }
  }

  public static LinkedList<int[]> path(int[][] path_info, int source) {
    HashMap<Integer, int[]> nodeXmap = new HashMap<Integer, int[]>();
    HashMap<Integer, int[]> nodeYmap = new HashMap<Integer, int[]>();
    LinkedList<int[]> foundPath = new LinkedList<int[]>();

    for(int i = 0; i < path_info.length; i++) {
      // We already found an edge with this node_x edge, turn it around
      if(nodeXmap.containsKey(path_info[i][0])) {
        int tmp = path_info[i][0];
        path_info[i][0] = path_info[i][1];
        path_info[i][1] = tmp;
      }
      nodeXmap.put(path_info[i][0], path_info[i]);
      nodeYmap.put(path_info[i][1], path_info[i]);
    }

    int current = source;
    // Use our maps to lookup where the next edge exists in our path,
    // since our input is guaranteed to be unique
    for(int i = 0; i < path_info.length; i++) {
      int[] currentEdge = nodeXmap.get(current);
      if (currentEdge == null) {
        currentEdge = nodeYmap.get(current);
        current = currentEdge[0];
      } else {
        current = currentEdge[1];
      }
      foundPath.add(currentEdge);
      nodeXmap.remove(currentEdge[0]);
      nodeYmap.remove(currentEdge[1]);
    }

    return foundPath;
  }
}