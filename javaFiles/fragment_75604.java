list.stream()
  .map(n -> {
     if (n > 9){ 
        return n * 2; 
      }
      else { 
        return n * 3; 
      }
    })
  .forEach(System.out::println);