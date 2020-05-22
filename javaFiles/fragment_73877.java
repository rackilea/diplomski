1.It gets the iterator.
2.Checks for hasNext().
public boolean hasNext() 
{
      return cursor != size(); // cursor is zero initially.
}
3.If true, gets the next element using next().

public E next() 
{
        checkForComodification();
        try {
        E next = get(cursor);
        lastRet = cursor++;
        return next;
        } catch (IndexOutOfBoundsException e) {
        checkForComodification();
        throw new NoSuchElementException();
        }
}

final void checkForComodification() 
{
    // Initially modCount = expectedModCount (our case 5)
        if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
}