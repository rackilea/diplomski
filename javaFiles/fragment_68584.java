public class Node<Key>{
    private Key key;
    private Node<Key> next;
    public Node(){
    key = null;
        next = this;
    }
    public Node(final Key k){
    key = null;
        next = this;
    }
    public Node(final Key k, final Node<Key> node){
        key = k;
        next = node;
    }
    public boolean isEmpty(){return key == null;}
    public Key getKey(){return key;}
    public void setKey(final Key k){key = k;}
    public Node<Key> getNext(){return next;}
    public void setNext(final Node<Key> n){next = n;}
}