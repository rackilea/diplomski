int[] ids = ...
List<UserObject> userObjects = ...
Collections.sort(userObjects, new Comparator<UserObject>() {
  public int compare(UserObject a, UserObject b) {
    return Ints.compare(
        Ints.indexOf(ids, a.getId()),
        Ints.indexOf(ids, b.getId()));
  }
});