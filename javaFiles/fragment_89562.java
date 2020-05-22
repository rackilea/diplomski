public final class TreeCollector<T>
    implements Collector<T, TreeCollector<T>, Tree<T>> {
  T value;
  Tree<T> root, current;
  public TreeCollector(T rootValue) {
    value=rootValue;
    current=root=new Tree<>(value);
  }
  public Supplier<TreeCollector<T>> supplier() {
    return ()->new TreeCollector<>(value);
  }
  public BiConsumer<TreeCollector<T>, T> accumulator() {
    return (c,t)->{ c.current=c.current.add(t); };
  }
  public BinaryOperator<TreeCollector<T>> combiner() {
    return (a,b)->{ a.root.addAll(b.root); return a; };
  }
  public Function<TreeCollector<T>, Tree<T>> finisher() {
    return x->x.root;
  }
  public Set<Characteristics> characteristics() {
    return Collections.emptySet();
  }
}