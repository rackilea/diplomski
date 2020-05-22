public class Node {
Node left; 
Node right; 
String data;
int depth;

Node(String newData, int depth) { 
    this.left = null; 
    this.right = null; 
    this.data = newData;
    this.depth = depth;
}

public Node getLeft() {
    return left;
}

public void setLeft(Node left) {
    this.left = left;
}

public Node getRight() {
    return right;
}

public void setRight(Node right) {
    this.right = right;
}

public String getData() {
    return data;
}

public void setData(String data) {
    this.data = data;
}

public int getDepth() {
    return depth;
}

public void setDepth(int depth) {
    this.depth = depth;
}
}