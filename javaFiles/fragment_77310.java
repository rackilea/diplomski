public class TernarySearchTree<T> {

    protected class TSTNode<U> {
      // index values for accessing relatives array:
      protected static final int PARENT = 0, LOKID = 1, EQKID = 2, HIKID = 3;

      protected char splitchar;
      protected List<TSTNode<U>> relatives;
      private U data;

      protected TSTNode(char splitchar, TSTNode<U> parent) {
        this.splitchar = splitchar;
        relatives = new ArrayList<TSTNode<U>>();
        for (int i = 0; i < HIKID; ++i) {  // Allocate 4 slots in relatives
          relatives.add(null);
        }
        relatives.set(PARENT, parent);
      }          
    }

    private TSTNode<T> node; // When you use it, pass T as U

    public TernarySearchTree() {
      node = new TSTNode<T>(',', null);  // When you use it, pass T as U 
    }
  }