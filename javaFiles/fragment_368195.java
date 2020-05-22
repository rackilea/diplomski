Collections.sort(myList, new Comparator<MyObject>() {
  public int compare(MyObject o1, MyObject o2) {
      if (o1.getDateTime() == null || o2.getDateTime() == null)
        return 0;
      return o1.getDateTime().compareTo(o2.getDateTime());
  }
});