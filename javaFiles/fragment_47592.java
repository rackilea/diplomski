public <T> List<T> computeList(/* arguments */, Function<? super Foo, T> f) {
     List<T> toReturn = ...     ...     
     for (Foo foo : /* some other list of Foo */) {
         if (/* some condition */) {
             toReturn.add(f.apply(foo));
         }
     }
     return toReturn;
}