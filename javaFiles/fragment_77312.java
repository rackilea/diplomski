public class TernarySearchTree<T> {

    protected class TSTNode {
      // index values for accessing relatives array:
      protected static final int PARENT = 0, LOKID = 1, EQKID = 2, HIKID = 3;

      protected char splitchar;
      protected Map<Integer, TSTNode> relatives;
      private T data;

      protected TSTNode(char splitchar, TSTNode parent) {
        this.splitchar = splitchar;
        // Create a hash map. No need to pre-allocate!
        relatives = new HashMap<Integer, TSTNode>(); 
        relatives.put(PARENT, parent); // set -> put
      }
    }

    private TSTNode node; 

    public TernarySearchTree() {
      node = new TSTNode(',', null);  
    }
  }
}