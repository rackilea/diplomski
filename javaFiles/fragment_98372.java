public E remove(int index) {
    rangeCheck(index);

    // Check if a modification should thrown a ConcurrentModificationException
    checkForComodification();  

    E result = parent.remove(parentOffset + index);
    this.modCount = parent.modCount;
    this.size--;
    return result;
}

final void checkForComodification() {
    if (expectedModCount != ArrayList.this.modCount)
        throw new ConcurrentModificationException();
    }
}