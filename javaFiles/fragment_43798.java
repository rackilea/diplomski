public boolean contain(T o) {
    if (o == null) { // assuming that your list accept to add null object
        for (Node<T> x = first; x != null; x = x.next) {
            if (x.data == null)
                return true;
        }
    } else {
        for (Node<T> x = first; x != null; x = x.next) {
            if (o.equals(x.data))
                return true;
        }
    }
    return false;
}