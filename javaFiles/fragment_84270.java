Arrays.stream(args)
      .map(Integer::parseInt)
      .map(number -> {
          int sum = 0;
          for(int i = 0; i < 10; i ++) {
              sum += number % 10;
              number /= 10;
          }
          return sum;
      })
      .forEach(System.out::println);