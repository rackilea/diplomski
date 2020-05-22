class ElementPriority implements Comparable<ElementPriority> {
    int element;
    int priority;

    @Override public int compareTo(ElementPriority other) {
        return Integer.compare(this.priority, other.priority);
    }
}