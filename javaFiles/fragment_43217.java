public class Report<T> implements Iterable<T>
{
  private ObservableList<T> items = FXCollections.observableArrayList();
  // ...

  public ObservableList<T> getItems() {
    return items;
  }

  public Iterator<T> iterator() {
    return items.iterator();
  }

  //  ...
}