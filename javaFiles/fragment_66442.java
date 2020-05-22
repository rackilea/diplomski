public static class MyElementList<T extends MyElement> {

  //Properties
  private List<T> elementList = new ArrayList<T>();

  //CTOR
  public MyElementList(List<T> initElements) {
      elementList.addAll(initElements);
  }

  //Getter
  public List<T> getElements() {
      return Collections.unmodifiableList(elementList);
  }
}