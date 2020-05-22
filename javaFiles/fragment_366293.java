public boolean equals(Object o){
  if(o instanceof Foo){
    Foo toCompare = (Foo) o;
    return this.id.equals(toCompare.id);
  }
  return false;
}