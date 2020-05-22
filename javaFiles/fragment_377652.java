public class CustomTreeNode extends DefaultMutableTreeNode {

    private int position;

    public CustomTreeNode(String text, int position){
        super(text);
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

}