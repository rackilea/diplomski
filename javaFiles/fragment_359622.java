new A() {
      public void go()
      {
        System.out.println("reachable - B");
      }
      public void foo()
      {
        System.out.println("unreachable - B");
      }
}.foo();