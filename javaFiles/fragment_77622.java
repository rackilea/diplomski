class MutableDouble {
    double sum, next;
    void add(double d) {
        sum=next;
        next+=d;
    }
}
MutableDouble sumHolder=new MutableDouble();
DoubleStream ds=IntStream.iterate(1, (i -> i + 1))
                         .mapToDouble(n -> 1 / ((double)n * n));
ds.peek(sumHolder::add)
  .filter(term -> Math.abs(term)<1e-12*Math.abs(sumHolder.sum))
  .findFirst();