public void Insert(int value) {
  root = Insert(root, value);
}

private node Insert(node r, int value) {
  if (r == null) {
    r = new node(value);
  }
  else if (value > r.data) {
    r.right = Insert(r.right, value);
  }
  else {
    r.left = Insert(r.left, value);
  }
  return r;
}