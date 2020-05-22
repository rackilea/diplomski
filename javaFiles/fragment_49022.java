public class Node{

int hitCount = 0; //this should be set in the constructor

public void hitCountIncrement() {
    hitCount++;
}

public void hitCountReset() {
    hitCount = 0;
}
}

public class BinaryTree {

    public void resetAllCounts(){
    for(Node currNode:Nodes){
        currNode.hitCountReset();
    } 
}