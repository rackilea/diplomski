public E remove(int index) {
    rangeCheck(index);
    checkForComodification();
    E result = l.remove(index+offset); // <-- here
    this.modCount = l.modCount;
    size--;
    return result;
}