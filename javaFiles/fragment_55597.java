import java.util.ArrayList;

public class Node{
    public String label;
    public ArrayList<Node> children;
    private int level;
    public Node(String label){
        this.level =0;
        this.label =label;
        this.children = new ArrayList<Node>();
    }

    public void addChild(String label){
        Node child = new Node(label);
        child.setLevel(this.getLevel()+1); //setting children level
        this.children.add(child);
    }
    public void addChild(Node child){
        child.setLevel(this.getLevel()+1); //setting children level
        this.children.add(child);
    }
    public Node findNode(String label){
        if(this.label.equals(label))
            return this;
        for(Node child : this.children)
            if (child.findNode(label) != null)
                return child.findNode(label);
        return null;
    }

    //note : This assumes you are at any Node searching for a child node. The root Node will have level = 0 ~important
    public Node findDeepNode(String label){
        Node tempNode = null;
        if(this.label.equals(label)&&this.findNode(label)==null){
            tempNode = this;
        }
        //traverse this' children
        for(Node child : this.children){
            Node t = child.findNode(label);
            if(t!=null){
                if(tempNode!=null){
                    if(tempNode.getLevel()<t.getLevel() && t.findDeepNode(label)==null){
                        tempNode=t;
                    }else tempNode=t.findDeepNode(label);
                }else{
                    if(t.findDeepNode(label)==null)
                        tempNode=t; //set TempNode = t as tempNode is null as this is our first solution
                    else tempNode=t.findDeepNode(label); //set TempNode = t.findDeepNode(label) as t has a child of the same label to put in tempNode instead
                }
            }
        }
        return tempNode; //can be null and Contains the lowest node in the tree with label
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public static void main(String[] args){
        Node node=new Node("E");
        node.addChild("E-");
        node.addChild("T-");
        node.addChild("7");
        node.findNode("E-").addChild("F");
        node.findNode("E-").addChild("T");
        node.findNode("T-").addChild("8");
        node.findNode("T-").addChild("9");
        node.findNode("9").addChild("9");
        node.findDeepNode("9").addChild("T");
        System.out.println(node.findDeepNode("T").level);
    }
}