List<A> getTopItems(List<A> elements, Function<A, Double> mapper, int n) {
    return elements.stream()
              .filter(a -> null != mapper.apply(a))                 
              .sorted(Comparator.<A>comparingDouble(a -> mapper.apply(a))
                      .reversed())
              .limit(n)
              .collect(Collectors.toList());
}