class Element {
    Object val;
    Element next;
    Element prev;

    public Element(Object val, Element next, Element prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

}

class LinkedList {
    Element head;
    Element tail;

    public void add(Object o) {
        Element el = new Element(o, null, tail);
        tail.next = el;
    }

    public Object remove() {
        Element o = tail;
        tail = o.prev;
        tail.next = null;
        return o.val;
    }
}