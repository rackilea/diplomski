public String toString() {
    String output = "";
    T result;
    LinearNode<T> tempHead = top;

    for (int i = 0; i < this.size(); i++) {
        result = tempHead.getElement();
        output = output + result;
        tempHead = tempHead.getNext();
    }

    return output;
}