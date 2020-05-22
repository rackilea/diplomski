public class RecLinkedList {
    private int size = 0;

    //...
    private Node add( String s, Node list){
        if( list == null ){
            this.size += 1;
            return new Node(s);
        }else{
            list.setNext( add( s, list.getNext() ) );
            return list;
        }
    }
    //...
}