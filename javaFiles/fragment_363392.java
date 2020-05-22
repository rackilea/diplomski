public T pop() {
    T elem;
    if (list!=null || list.isEmpty()) {
        elem=list.get(this.getSize()-1);
        list.remove(this.getSize()-1);
        return elem;
    } else return null;
}