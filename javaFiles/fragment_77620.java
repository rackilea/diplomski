class MutableDouble {
    double sum;
}
MutableDouble sumHolder=new MutableDouble();
DoubleStream ds=IntStream.iterate(1, (i -> i + 1))
                         .mapToDouble(n -> 1 / ((double)n * n));
ds.peek(term -> sumHolder.sum+=term)
  .filter(term -> Math.abs(term)<1e-12*Math.abs(sumHolder.sum))
  .findFirst();
System.out.println(sumHolder.sum);