else {
    cursor.getPrev().setNext(cursor.getNext());
    cursor.getNext().setPrev(cursor.getPrev());
    // You might want to release the cursor's item, EG:
    cursor = null;
    cursor = cursor.getNext();
}