public class BinaryTree{
    private BinaryTree right;
    private BinaryTree left;
    private String data;        

    public BinaryTree(String s){
        data = s;
        right = null;
        left = null;           
    }

    public void setLeft (BinaryTree l){ left  = l; }
    public void setRight(BinaryTree r){ right = r; }        
}