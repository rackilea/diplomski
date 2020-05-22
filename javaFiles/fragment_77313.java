public class TernarySearchTree<T> {

    protected static enum Index {
      PARENT, LOKID, EQKID, HIKID;
    }

    protected class TSTNode {    
      protected char splitchar;
      protected EnumMap<Index, TSTNode> relatives;
      private T data;

      protected TSTNode(char splitchar, TSTNode parent) {
        this.splitchar = splitchar;
        // Create an EnumMap. 
        relatives = new EnumMap<Index, TSTNode>(Index.class);
        relatives.put(Index.PARENT, parent); 
      }
    }

    private TSTNode node; 

    public TernarySearchTree() {
      node = new TSTNode(',', null);  
    }
  }