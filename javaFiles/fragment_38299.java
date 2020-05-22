class MyBatchIterator<E> {
    MyBatchIterator(Iterator<E> iterator,int n) {
        this.iterator=iterator;
        this.n=n;
    }
    public boolean hasNext() {
        return iterator.hasNext();
    }
    public List<E> next() {
        List<E> list=new ArrayList<>(n);
        for(int i=0;i<n;i++)
            if(iterator.hasNext()) list.add(iterator.next());
        return list;
    }
    final Iterator<E> iterator;
    final int n;
}