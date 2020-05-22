@Override
public String toString() {
    Listnode<E> temp = items;
    StringBuilder sb = new StringBuilder();
    while (temp != null) {
        sb.append(temp.getValue()).append(", "); // I'm guessing
        temp = temp.getNext();
    }
    return sb.toString();
}