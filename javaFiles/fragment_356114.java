public class BinaryTree {
    private BinaryTree right;
    private BinaryTree left;
    private String data;
    private int weight;

    public BinaryTree(String s){
        data = s;
        right = null;
        left = null; 
        weight = 1;
    }    

    public void setLeft (BinaryTree l){ 
        left  = l;
        weight++;
    }

    public void setRight(BinaryTree r){
        right = r;
        weight++;
    } 

    public int getWeight(){ return weight; }

    public void insert(BinaryTree bt){
        if(left == null){
            setLeft(bt);
        }else if(right == null){
            setRight(bt);
        }else{
            if(left.getWeight() <= right.getWeight()){
                left.insert(bt);
                weight++;
            }else{
                right.insert(bt);
                weight++;
            }
        }
    }    
}