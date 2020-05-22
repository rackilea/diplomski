/MyClass.java:6: error: incompatible types: cannot infer type-variable(s) R
                .flatMap(name ->  IntStream.range(0, name.length())) 
                        ^
    (argument mismatch; bad return type in lambda expression
      IntStream cannot be converted to Stream<? extends R>)
  where R,T are type-variables:
    R extends Object declared in method <R>flatMap(Function<? super T,? extends Stream<? extends R>>)
    T extends Object declared in interface Stream
1 error