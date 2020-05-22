private int indexOfItem(T item) {
  for(int i = 0; i < bigList.size(); i++) {
    if(bigList.get(i).contains(item)) {
      return i;
    }
  }
  return -1;
}