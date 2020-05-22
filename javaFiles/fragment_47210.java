public String toString() {
    String result = item + " ";
    if (next != null) {
        result += next.toString();
    }
    return result;
}