public boolean isEmpty() {
     return head == tail;
}

public boolean isFull() {
     // don't forget about the modulo here
     return head == ((tail - 1) % capacity);
}