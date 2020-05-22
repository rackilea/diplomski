public int get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > length) {
        throw new IndexOutOfBoundsException();
    } else {
        Node cursor = head;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }
        return cursor.getValue();
    }
}