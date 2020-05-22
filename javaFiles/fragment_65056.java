public interface IListable<T> {
  //returns first n items from list
  public ArrayList<T> getFirstNThings(int n);

  //returns last n items from list
  public ArrayList<T> getLastNThings(int n);
}