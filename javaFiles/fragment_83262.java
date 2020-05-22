public E remove() {
    if (rear == null) {
        // NoSuchElementException is from java.util and its constructor has no argument.
        throw new NoSuchElementException("Queue underflow");
    }

    E answer = rear.getLink().getData();

    if (rear.getLink() == rear) {
        // this is the last item in the list
        rear = null;
    }
    else {
        // point rear to the one after front so that front is removed
        rear.setLink(rear.getLink().getLink());
    }
    manyNodes--;
    return answer;
}