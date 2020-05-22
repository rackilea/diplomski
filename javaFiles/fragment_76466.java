public class Node implements Comparable<Node>{

private final Node left;
private final Node right;
private final int value;
private final int index;
private String code = "";

public Node(Node left, Node right, int value){
    this.left = left;
    this.right = right;
    this.value = value;
    this.index = -1;
}

public Node(int value, int index){
    this.index = index;
    this.value = value;
    this.left = null;
    this.right = null;
}

public void generateCodes(String[] codes){
    if(left != null && right != null){
        left.setCode("0"+getCode());
        left.generateCodes(codes);
        right.setCode("1"+getCode());
        right.generateCodes(codes);
    }else{
        codes[index] = getCode();
    }
}

private void setCode(String code){
    this.code = code;
}

public String getCode(){
    return code;
}

public Node getLeft() {
    return left;
}

public Node getRight() {
    return right;
}

public int getValue(){
    return value;
}

public int getIndex() {
    return index;
}

@Override
public int compareTo(Node other) {
    if(other == null)
        return -1;

    return Integer.compare(getValue(), other.getValue());
}

}