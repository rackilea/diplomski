Arrays.asList(1, 2, 3)
  .forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
          System.out.println(integer);
      }
  });