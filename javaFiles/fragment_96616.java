class MyArrayList<E> extends ArrayList<E> {

  public void setAll(Collection<E> collection) {
    clear();
    addAll(collection);
  }

}