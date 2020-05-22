static DoubleStream iterate(double seed, DoubleUnaryOperator f, long limit) {
  return StreamSupport.doubleStream(new Spliterators.AbstractDoubleSpliterator(limit,
     Spliterator.ORDERED|Spliterator.SIZED|Spliterator.IMMUTABLE|Spliterator.NONNULL) {
       long remaining=limit;
       double value=seed;
       public boolean tryAdvance(DoubleConsumer action) {
           if(remaining==0) return false;
           double d=value;
           if(--remaining>0) value=f.applyAsDouble(d);
           action.accept(d);
           return true;
       }
   }, false);
}