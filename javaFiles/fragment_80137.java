List<A> getTopItems(List<A> elements, ToDoubleFunction<A> mapper, int n) {
    return elements.stream()
              .sorted(Comparator.comparingDouble(mapper).reversed())
              .limit(n)
              .collect(Collectors.toList());
}