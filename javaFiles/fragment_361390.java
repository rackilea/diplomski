class MyCollection implements Collection<E /* or whatever the elements are */> {
    private int modCount = 0;
    private class MyIterator implements Iterator<E> {
         private int expectedModCount;
         public MyIterator() {
              expectedModCount = modCount;
         }
         @Override
         public E next() {
             if(expectedModCount != modCount) throw new ConcurrentModificationException();
         }
         // etc.
    }
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
    @Override
    public boolean add(E e) {
       modCount++;
       // etc.
    }
    // etc.
}