public boolean find(T key) {
    ListItem<T> tmpListItem = this;
    while(tmpListItem.next != null) {
        if(tmpListItem.key.equals(key))
           return true;
        tmpListItem = tmpListItem.next;
    }
}