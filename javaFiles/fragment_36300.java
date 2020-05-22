import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {
  private List<Integer> currentPath = new ArrayList<Integer>();
  private List<Integer[]> paths = new ArrayList<Integer[]>();
  private ArrayList<Set<Integer>> tree;
  private Integer root;
  /**
   * constructor
   * @param tree
   */
  public DFS(ArrayList<Set<Integer>> tree) { 
    this.tree = tree;
  }

  public List<Integer[]> getPaths() {
    return paths;
  }
  public void setPaths(List<Integer[]> paths) {
    this.paths = paths;
  }
  public Integer getRoot() {
    return root;
  }
  public void setRoot(Integer root) {
    this.root = root;
  }

/**
 * initializes our search, sets the root and adds it to the path
 */
  public void initialize() {
    root = -1;
    for (Integer node : tree.get(0)) {
      root = node;
    }
    currentPath.add(root);
  }

  /**
   * This returns the adjacent nodes to an integer node in the tree
   * @param node
   * @return a set of adjacent nodes, and null otherwise
   */
  public Set<Integer> getAdjacentsToNode(Integer node) {

    for (int i = 0; i < tree.size(); i++) {
      Set<Integer> level = tree.get(i);
      if (level.contains(node) && i < tree.size() - 1) {
        return tree.get(i + 1);
      }
    }
    return null;
  }

  /**
   * runs a DFS on the tree to retrieve all paths
   * @param tree
   */
  public void runDFS(Integer node) {
    if (getAdjacentsToNode(node) != null) {
      for (Integer adjNode : getAdjacentsToNode(node)) {
        currentPath.add(adjNode);
        runDFS(adjNode);
      }
      currentPath.remove(currentPath.size() -1);
    } else {
      paths.add(currentPath.toArray(new Integer[0]));
      currentPath.remove(currentPath.size() -1);
    }
  }
}