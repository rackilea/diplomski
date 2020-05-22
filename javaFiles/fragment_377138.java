class Collection {
    Iterator iterator() { ... }
}

class List extends Collection {
    @Override 
    ListIterator iterator() { ... }
}