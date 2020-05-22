final ImmutableList<String> m = ImmutableList.of("a", "b");
final ImmutableList<Integer> f = ImmutableList.of(3, 1);

final ImmutableList<String> values = FluentIterable.from(m).
  transformAndConcat(new Function<String, Iterable<String>>() {

    int c = 0;

    public Iterable<String> apply(String input) {
        return Collections.nCopies(f.get(c++), input);
    }
}).toList();

final ImmutableSet<List<String>> permutations = ImmutableSet.copyOf(Collections2.permutations(values));
System.out.println(Joiner.on("\n").join(permutations));