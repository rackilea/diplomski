ImmutableList<B> listOfBs = FluentIterable.from(listOfAs)
  .transformAndConcat(new Function<A, List<B>>(){
      public List<B> apply(A a) {
        return a.bList;
      }
   })
   .toList();