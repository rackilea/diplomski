public class Element {
    private int value = 0;
    private Element next = null;
    private Element previous = null;

    public Element(int value, Element next, Element previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Element insertBefore(int value) {
        Element that = new Element(value, this, null);
        previous = that;
        return that;
    }
} 

public class Liste {
    private Element first;
    private Element last;

    void addFirst(int value) {
        if (first == null) {
            Element newElement = new Element(value, null, null);
            first = newElement;
            last = newElement;
        } else {
            first = first.insertBefore(value);
        }
    }
}