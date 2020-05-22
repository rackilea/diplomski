public void remove()
{
    if (!canRemove)
    {
        throw new IllegalStateException();
    }
    SortedLinkedList.this.remove(previousLoc--);
    canRemove = false;
}