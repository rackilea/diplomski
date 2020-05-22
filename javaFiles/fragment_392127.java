Set<To> result = FluentIterable.from(myList)
                               .transform(new Function<From, To>() {
                                   @Override
                                   public To apply(From input) {
                                       return convert(input);
                                   }
                               })
                               .toSet();