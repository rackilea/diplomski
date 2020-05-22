abstract class Node<N extends  Node<N, T, U>, T extends List<N>, U>
{
    public Node<N, T, U> parent;
    public T children;
    public U data;

    private Class<T> tClass;

    public Node(Class<T> tClass) throws InstantiationException, IllegalAccessException
    {
        this.tClass = tClass;
        this.children = this.tClass.newInstance();
    }
    {
        Node<ALNode<Integer>, ArrayList<ALNode<Integer>>, Integer> node = new ALNode<Integer>();
        ALNode<Integer> node2 = new ALNode<Integer>();
    }
}

class ALNode<U> extends Node<ALNode<U>, ArrayList<ALNode<U>>, U> {

    public ALNode() throws InstantiationException,
            IllegalAccessException {
        super((Class) ArrayList.class);
    }

}