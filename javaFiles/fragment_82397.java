public List<String> allMatchingElements(final List<String> elements) {
    final _14 arg = this;
    return elements.stream()
                   .filter(e -> e.contains(arg.pattern))
                   .collect(toList());
}