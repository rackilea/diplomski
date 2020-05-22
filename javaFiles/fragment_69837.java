class IndexableHeap
{
    MeldableHeap theHeap;
    HashMap<key, Node> index

    void add(node)
    {
        theHeap.add(node);
        index.add(node.x, node);
    }

    remove()
    {
        theHeap.remove(node);
        index.remove(node.x);
    }
}