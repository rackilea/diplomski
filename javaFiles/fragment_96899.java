package org.test.junk;

public class BTreeNode {

protected BTreeNode right;
protected BTreeNode left;

public void add(BTreeNode node, NodePosition nodePosition) {

    switch(nodePosition) {

        case left:{this.left=node;break;}
        case right:{this.right=node;break;}

    }//switch closing

}//add closing

public void remove(NodePosition nodePosition) {

    switch(nodePosition) {

        case left:{remove(left);break;}
        case right:{remove(right);break;}

    }//switch closing

}//remove closing

public void remove(BTreeNode node) {

    if(node==null)return;

    if(node.equals(right)) {

        if(this.right!=null) {

            this.right.remove(NodePosition.right);
            this.right.remove(NodePosition.left);
            this.right=null;

        }//if closing

    }//if closing
    else if(node.equals(left)) {

        if(this.left!=null) {

            this.left.remove(NodePosition.right);
            this.left.remove(NodePosition.left);
            this.left=null;

        }//if closing

    }//else if closing
    else return;

}//remove closing

public static enum NodePosition{

    right,left;

}//enum closing

}//class closing