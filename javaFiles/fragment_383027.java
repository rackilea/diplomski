void test(Object o) {
    if(o.getClass().isAnonymousClass()) {
      System.out.println(o.getClass().getInterfaces()[0].getName());
    } else {
      System.out.println(o.getClass().getName());
    }        
}