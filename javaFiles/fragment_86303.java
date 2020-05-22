void myMethodQuietly(YourItemType item) {
  try {
    myMethod(item);
  }catch(Exception e){
    //omit or throw new RuntimeException(e);
  }
}

Stream.of(your,items,here).forEach(this::myMethodQuietly);