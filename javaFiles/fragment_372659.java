public <T> void meth(T t){
  if(Collection.class.isAssignableFrom(t.getClass())) {
    System.out.println(true);
  } else {
    System.out.println(false);
  }