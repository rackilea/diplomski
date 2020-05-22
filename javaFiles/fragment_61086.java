public class BinaryNode implements BaseNode{
    private BinaryNode right;
    private BinaryNode left;
    private int data;
    //...

    public BinaryNode traverseTree(int Data){
        final BinaryNode rvalue;
        if (getData() == Data){
            rvalue = this;
        }
        else if (Data < getData() && getLeft() != null){
            rvalue = getLeft().traverseTree(Data);
        }
        else if(Data > getData() && getRight() != null){
            rvalue = getRight().traverseTree(Data);
        }
        else {
            rvalue = null;
        }
        return rvalue;
    }
}