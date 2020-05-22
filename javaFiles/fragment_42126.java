// Private implementation
private static <T> boolean rotateOneElementImpl(List<T> l){
    return l.add(l.remove(0));
}

//Public interface
static void rotateOneElement(List<?> l){
     rotateOneElementImpl(l);
}