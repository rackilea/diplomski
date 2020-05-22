public Key getRecursive(int goal, int current, Node<Key> item) {
// TODO Check for legal input here!
    if (goal == current) {
        return item.getValue();
    }//base
    else {
        //return ( item.hasNext()?getRecursive(goal, current++, item.getNext()):null); <- will not work with current++ !!
        return ( item.hasNext()?getRecursive(goal, current+1, item.getNext()):null);
    }

}