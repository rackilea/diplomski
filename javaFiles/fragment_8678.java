public class MyClass<E> extends Observable {

  private ArrayList<E> items = new ArrayList<E>();

  private boolean changing;

  public void update(ObservableChange<MyClass2<E>> observableChange) {
    setIsChanging(true);
    try {
      observableChange.doChange(this);
    } finally {
      setIsChanging(false);
    }

  }

  private void setIsChanging(boolean changing) {
    this.changing = changing;
    if (!changing && hasChanged()) {
      notifyObservers();
    }
  }

  public void add(E e) {
    this.items.add(e);
    notifyChanged();
  }

  public void remove(E e) {
    if (this.items.remove(e)) {
      notifyChanged();
    }
  }

  private void notifyChanged() {
    setChanged();
    if (!changing) {
      notifyObservers();
    }
  }
}