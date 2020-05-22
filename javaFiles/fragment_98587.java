public Optional<String> myMethod(int i) {
     if(i>0) {
          return Optional.of("Hello");
     } else {
          return Optional.empty();
}