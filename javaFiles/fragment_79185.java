public String toString() {
    String result = "[ Top = " + size +"]" + "[Stack = [";

    if (top == null) {
        return result + "]]";

    Node temp = top;
    while (temp != null) {
        result += temp + ', '
        temp = temp.next;
    }

    return result += temp.element + "]]";
}