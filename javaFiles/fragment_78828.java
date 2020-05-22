private static class LogDecorator<T> implements Collection<T> {
    private final Collection<T> delegate;

    private LogDecorator(Collection<T> delegate) {this.delegate = delegate;}

    @Override
    public int size() {
      return delegate.size();
    }

    @Override
    public boolean isEmpty() {
      return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
      return delegate.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
      return delegate.iterator();
    }

    @Override
    public Object[] toArray() {
      return delegate.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
      return delegate.toArray(a);
    }

    @Override
    public boolean add(T t) {
      // ADD YOUR INTERCEPTING CODE HERE

      return delegate.add(t);
    }

    @Override
    public boolean remove(Object o) {
      return delegate.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
      return delegate.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
      return delegate.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
      return delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
      return delegate.retainAll(c);
    }

    @Override
    public void clear() {
      delegate.clear();
    }
  }