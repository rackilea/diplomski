public Key getRecursive(int goal, int current, Node<Key> item) {
    if (goal == current) {
        return item.getValue();
    }//base
    else {
        getRecursive(goal, current++, item.getNext()); //exception here
    }
    return null;
}