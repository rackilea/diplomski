public class TernarySearchTree<T> {

    protected class TSTNode {
      // index values for accessing relatives array:
      protected static final int PARENT = 0, LOKID = 1, EQKID = 2, HIKID = 3;

      protected char splitchar;
      protected List<TSTNode> relatives;
      private T data;

      protected TSTNode(char splitchar, TSTNode parent) {
        this.splitchar = splitchar;
        relatives = new ArrayList<TSTNode>();
        for (int i = 0; i < HIKID; ++i) {  // Allocate 4 slots in relatives
          relatives.add(null);
        }
        relatives.set(PARENT, parent);
      }
    }

    private TSTNode node; 

    public TernarySearchTree() {
      node = new TSTNode(',', null);  
    }
  }