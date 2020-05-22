public class FilteredObservableList<E> extends DecoratingObservableList
{
  private final IObservableList decorated;
  private final Predicate pred;
  private final List<E> filtered = new ArrayList();

  public FilteredObservableList(
      IObservableList decorated, Predicate pred, boolean disposeDecoratedOnDispose)
  {
    super(decorated, disposeDecoratedOnDispose);
    this.decorated = decorated;
    this.pred = pred;
    for (Object o : decorated) filtered.add(pred.eval(o)? (E) o : null);
  }

  @Override protected void handleListChange(ListChangeEvent event) {
    final List<ListDiffEntry> diffs = new ArrayList();
    final List<Integer> mapping = new ArrayList();
    int i = 0;
    for (E e : filtered) mapping.add(e != null? i++ : i);
    event.diff.accept(new ListDiffVisitor() {
      @Override public void handleAdd(int index, Object element) {
        final boolean passes = pred.eval(element);
        filtered.add(index, passes? (E) element : null);
        final Integer outInd = mapping.get(index);
        mapping.add(index, outInd);
        if (passes) {
          diffs.add(new FilteredDiffEntry(outInd, true, element));
          for (int i = index + 1; i < mapping.size(); i++)
            mapping.set(i, mapping.get(i) + 1);
        }
      }
      @Override public void handleRemove(int index, Object element) {
        final boolean passes = filtered.get(index) != null;
        filtered.remove(index);
        final int outInd = mapping.get(index);
        mapping.remove(index);
        if (passes) {
          diffs.add(new FilteredDiffEntry(outInd, false, element));
          for (int i = index; i < mapping.size(); i++)
            mapping.set(i, mapping.get(i)-1);
        }
      }
    });
    if (!diffs.isEmpty()) {
      final ListDiffEntry[] difAry = diffs.toArray(new ListDiffEntry[diffs.size()]);
      fireListChange(new ListDiff() {
        @Override public ListDiffEntry[] getDifferences() { return difAry; }
      });
    }
  }

  public ListIterator<E> listIterator() {
    getterCalled();
    final Iterator<E> it = decorated.iterator();
    return new ListIterator<E>() {
      E next;
      boolean nextReady;
      public boolean hasNext() {
        getterCalled();
        if (nextReady) return true;
        while (it.hasNext()) {
          next = it.next();
          if (next != null) { nextReady = true; break; }
        }
        return nextReady;
      }
      public E next() {
        getterCalled();
        if (hasNext()) { nextReady = false; return next; }
        else throw new NoSuchElementException();
      }
      public void add(Object o) { throw new UnsupportedOperationException(); }
      public boolean hasPrevious() { throw new UnsupportedOperationException(); }
      public int nextIndex() { throw new UnsupportedOperationException(); }
      public E previous() { throw new UnsupportedOperationException(); }
      public int previousIndex() { throw new UnsupportedOperationException(); }
      public void remove() { throw new UnsupportedOperationException(); }
      public void set(Object o) { throw new UnsupportedOperationException(); }
    };
  }

  public interface Predicate { boolean eval(Object o); }

  private static final class FilteredDiffEntry extends ListDiffEntry {
    private final int pos;
    private final boolean isAdd;
    private final Object el;
    FilteredDiffEntry(int pos, boolean isAdd, Object el) {
      this.pos = pos; this.isAdd = isAdd; this.el = el;
    }
    @Override public int getPosition() { return pos; }
    @Override public boolean isAddition() { return isAdd; }
    @Override public Object getElement() { return el; }
  }

  @Override public Object move(int _, int __) { throw new UnsupportedOperationException(); }
  @Override public Object remove(int _) { throw new UnsupportedOperationException(); }
  @Override public Object set(int _, Object __) { throw new UnsupportedOperationException(); }
  @Override public void add(int _, Object __) { throw new UnsupportedOperationException(); }
  @Override public boolean add(Object _) { throw new UnsupportedOperationException(); }
  @Override public boolean addAll(Collection _) { throw new UnsupportedOperationException(); }
  @Override public boolean addAll(int _, Collection __) {
    throw new UnsupportedOperationException();
  }
  @Override public void clear() { throw new UnsupportedOperationException(); }
  @Override public boolean remove(Object _) { throw new UnsupportedOperationException(); }
  @Override public boolean removeAll(Collection _) { throw new UnsupportedOperationException();}
  @Override public boolean retainAll(Collection _) { throw new UnsupportedOperationException();}
}