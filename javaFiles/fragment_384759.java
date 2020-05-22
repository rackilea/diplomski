public R get(int index) throws IndexException {
  checkBounds(index);
  return this.info[index];
}

public void set(int index, R r) throws IndexException {
  checkBounds(index);
  this.info[index] = r;
}