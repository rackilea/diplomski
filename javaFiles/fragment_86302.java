Stream.of(your,items,here).forEach(item -> {
  try {
    myMethod(item);
  } catch (Exception e){
    //omit or throw new RuntimeException(e);
  };