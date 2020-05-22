public class ReversibleTopoIterator extends TopologicalOrderIterator{
    Stack<V> back=new ...
    Stack<V> front=new ...

    public V next(){
        V v;
        if(front.isEmpty())
            v=super.next();
        else
            v=front.pop();
        back.push(v);
        return v;
    }
    public V previous(){
        V v=back.pop();
        front.push(v);
        return v;
    }
    public boolean hasNext(){return !front.isEmpty() || super.hasNext()};
    public boolean hasPrevious(){return !back.isEmpty()}
}