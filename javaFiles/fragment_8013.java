Iterator<T> it = new Iterator<T>() {

    Node<T> next;

    {
        next = root;
        while (next.left != null)
            next = next.left;
    }

    @Override
    public boolean hasNext() {
        return next != null;     
    }

    //...
}