int index = Collections.binarySearch(users, u);
if(index < 0) {
  int insertionPoint = -(index + 1);
  users.add(insertionPoint, u);
  fireIntervalAdded(this, insertionPoint, insertionPoint);
}