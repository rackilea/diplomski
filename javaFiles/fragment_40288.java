public DSAStack(int maxCapacity) {
        list = new DSALinkedList[maxCapacity];
    }

    public int getCount() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty(); 
    }

    public boolean isFull() {
        return list.isFull();          
    }

    public void push(Object value) {
        list.insertLast(value);
    }

    public Object pop() {
        return list.removeLast();
    }

    public Object top() {
        return list.peekLast();
    }

    public Iterator iterator() {
        return list.iterator();
    }
}