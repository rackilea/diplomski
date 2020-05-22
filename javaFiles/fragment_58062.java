public class Node {
    public MyPoint myPoint;  // note that MyPoint NOT created here

    public Node(MyPoint myPoint) {
        this.myPoint = myPoint; // but rather passed in HERE
    }
}