public B bWith(Object it){
  if (it == null || it instanceof Integer) {
    return new B((Integer) it);
  }
  return new B(it);
}