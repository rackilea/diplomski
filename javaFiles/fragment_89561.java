public final class Tree<T> {
  T value;
  Map<T,Tree<T>> sub=Collections.emptyMap();
  public Tree(T value) {
    this.value=value;
  }
  public Tree<T> add(T value) {
    if(sub.isEmpty()) sub=new HashMap<>();
    return sub.computeIfAbsent(value, Tree::new);
  }
  public void addAll(Tree<T> tree) {
    if(!tree.sub.isEmpty()) {
      if(sub.isEmpty()) sub=new HashMap<>();
      for(Tree<T> t: tree.sub.values()) add(t.value).addAll(t);
    }
  }
  public <R> R forAll(
    Function<T, R> open, Function<T, R> single, Function<T, R> close,
    BiFunction<R,R,R> combiner) {
      if(sub.isEmpty()) return single.apply(value);
      else {
        Iterator<Tree<T>> it=sub.values().iterator();
        R result = value!=null? open.apply(value):
          it.next().forAll(open, single, close, combiner);
        while(it.hasNext())
          result=combiner.apply(result, it.next().forAll(open,single,close,combiner));
        return value!=null? combiner.apply(result, close.apply(value)): result;
      }
  }
}