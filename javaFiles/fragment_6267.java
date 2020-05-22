ListElement head2 = null;
int length = head.getLength();

while (head != null) {
    int k = (int) Math.random() * length;

    // Assume there is function deleteAt(index) that removes
    // the element at specified index and returns the deleted
    // element
    ListElement e = head.deleteAt(k);
    // Although I can just give the implementation - I'll leave this
    // as exercise.

    // You can have a function that add element to front
    // head2.addFront(e);
    e.setNext(head2);
    head2 = e;

    // Instead of querying the length again
    // decrement the length
    length--;
}
return head;