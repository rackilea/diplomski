Collections.sort(myObjectList, new Comparator<MyObject>() {
  @Override
  int compare(MyObject a, MyObject b) {
    if (a.getStartTime().equals(b.getStartTime())) {
      return a.getMachineName().compare(b.getMachineName());
    } else {
      return a.getStartTime().compare(b.getStartTime());
    }
  }
});