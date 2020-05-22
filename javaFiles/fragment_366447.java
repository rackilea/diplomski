public E remove(int index) {
    rangeCheck(index); // throws an exception if out of bounds

    modCount++;        // each time a structural change happens
                       // used for ConcurrentModificationExceptions

    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // Let gc do its work

    return oldValue;
}