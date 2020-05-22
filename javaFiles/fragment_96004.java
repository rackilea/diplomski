List<ListenableFuture<A>> individuals = newArrayList();
for (int i = 0; i < knownSize; i++) {
  final int index = i;
  individuals.add(transform(input, new Function<List<A>, A>() {
    @Override
    public A apply(List<A> values) {
      return values.get(index);
    }
  }));
}

List<ListenableFuture<B>> result = newArrayList();
for (ListenableFuture<A> original : individuals) {
  result.add(transform(original, function, executor));
}
return result;