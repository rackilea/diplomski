int expectedModCount = modCount;

public E next() {
   checkForComodification();
   [...]
}

final void checkForComodification() {
    if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
}