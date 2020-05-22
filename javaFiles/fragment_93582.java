public T get(T el){
    SLLNode<T> tmp;
    for(tmp = head; tmp != null && tmp.info.equals(el); tmp = tmp.next);

    return tmp.info;  // Changed line
}