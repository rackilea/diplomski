private void ensureCapacity(int capacity)
{
    if (elementData.length < capacity)
    {
        int newCapacity = elementData.length * 2 + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}