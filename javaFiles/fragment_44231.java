public class DistinctList<E> extends TransformationList<E,E> {

    private final ObservableList<E> distinctList = FXCollections.observableArrayList();
    private final ConcurrentHashMap<E,E> distinctValues = new ConcurrentHashMap<>();
    private final ObservableList<E> source;


    public DistinctList(ObservableList<E> source) {
        super(source);
        this.source = source;
        source.stream().forEach(s -> attemptAdd(s));
    }
    private boolean attemptAdd(E e) {
        final boolean result = distinctValues.putIfAbsent(e,e) == null;
        if (result) {
            distinctList.add(e);
        }
        return result;
    }
    private boolean attemptRemove(E e) {
        final boolean result = distinctValues.remove(e, e);
        if (result) {
            distinctList.remove(e);
        }
        return result;
    }

    @Override
    protected void sourceChanged(ListChangeListener.Change<? extends E> c) {

      while (c.next()) {
          ListChangeListener.Change<E> change = new ListChangeListener.Change<E>(this) {
              @Override
              public boolean wasAdded() {
                  if (c.getAddedSubList().stream().filter(v -> distinctValues.contains(v) == false).findAny().isPresent()) {
                      return true;
                  } else {
                      return false;
                  }
              }

              @Override
              public List<E> getAddedSubList() {
                return c.getAddedSubList().stream().filter(v -> distinctValues.contains(v) == false).collect(Collectors.toList());
              }

              @Override
              public boolean wasRemoved() {
                  if (c.getRemoved().stream().filter(v -> source.contains(v) == false).findAny().isPresent()) {
                      return true;
                  } else {
                      return false;
                  }
              }

              @Override
              public boolean wasPermutated() {
                  return false;
              }


              @Override
              protected int[] getPermutation() {
                  throw new AssertionError("getPermutation() not implemented");
              }

              @Override
              public List<E> getRemoved() {
                  return c.getRemoved().stream().filter(v -> source.contains(v) == false)
                          .collect(Collectors.toList());
              }

              @Override
              public int getFrom() {
                  return 0;
              }

              @Override
              public int getTo() {
                  return 0;
              }

              @Override
              public boolean next() {
                  return c.next();
              }

              @Override
              public void reset() {
                  c.reset();
              }
          };

          if (change.wasAdded()) {
              change.getAddedSubList().stream().filter(v -> !distinctValues.containsKey(v)).peek(a -> System.out.println("ADDING FROM MAP " + a)).forEach(a -> attemptAdd(a));
          }
          if (change.wasRemoved()) {
              change.getRemoved().stream().filter(v -> distinctValues.containsKey(v)).peek(a -> System.out.println("REMOVING FROM MAP " + a)).forEach(a -> attemptRemove(a));
          }
          fireChange(change);
      }

    }

    @Override
    public int getSourceIndex(int index) {
        return IntStream.range(0,source.size()).filter(i -> source.get(i).equals(this.get(i))).findAny().orElse(-1);
    }

    @Override
    public E get(int index) {
        return distinctList.get(index);
    }

    @Override
    public int size() {
        return distinctList.size();
    }
}