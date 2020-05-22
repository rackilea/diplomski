public List<Set<String>> permutations(final Set<String> input) {
    if (input.size() == 1) {
        return Arrays.asList(input);
    }
    final List<Set<String>> output = new ArrayList<>();
    final Iterator<String> iter = input.iterator();
    while (iter.hasNext()) {
        final String item = iter.next();
        final Set<String> copy = new LinkedHashSet<>(input);
        copy.remove(item);
        for (final Set<String> rest : permutations(copy)) {
            rest.add(item);
            output.add(rest);
        }
    }
    return output;
}