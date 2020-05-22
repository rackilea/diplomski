class ClassEntry{
  float a;
  int b;

  public ClassEntry(float a, int b){
    //...
  }

  @Override
  public boolean equals(Object o){
    if(o instanceof ClassEntry){
      ClassEntry c = (ClassEntry)o;
      return a == c.a && b == c.b;
    }
    return false;
  }
}