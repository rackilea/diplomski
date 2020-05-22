List<ListenableFuture<B>> result = newArrayList();
for (int i = 0; i < knownSize; i++) {
  final int index = i;
  result.add(transform(input, new Function<List<A>, B>() {
    @Override
    public B apply(List<A> values) {
      return function.apply(values.get(index));
    }
  }, executor));
}
return result;