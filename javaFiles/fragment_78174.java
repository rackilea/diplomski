private Node findExact(int target) {
    Node init = head;
    int index = 0;
    int size = this.getSize();

    while(index < size) {
        if(init.data == target)
            return init;
        init = init.next;
        index++;
    }
    return null;
}