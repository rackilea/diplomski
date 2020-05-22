public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree
    private DBTreeNode VehicleDetails; // your list

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
    this.VehicleDetails = new DBTreeNode(); // initialize your list
        }

    public DBTreeNode getDetails(){
        return this.VehicleDetails; 
    }

    public void addDetails(DBTreeNode details){
        for(DBTreeNodeElement detail : details) this.VehicleDetails.add(detail);
    }
    }