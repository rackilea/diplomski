class NotQuiteImmutableList<T> {
  private final List<T> list;

  public NotQuiteImmutableList(List<T> list) {
    // creates a new ArrayList and keeps a reference to it.
    this.list = new ArrayList(list); 
  }

  public List<T> getList() {
    return list;
  }
}