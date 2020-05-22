public interface IListable {
  //returns first n items from list
  public ArrayList<?> getFirstNThings(int n);

  //returns last n items from list
  public ArrayList<?> getLastNThings(int n);
}