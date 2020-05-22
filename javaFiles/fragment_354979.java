class Node<T> {
    List<T> list = new ArrayList<>();

    public boolean addNodeToList(T e){
        list.add(e);
        return true;
    }
}