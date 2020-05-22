static <T> Collector<T, ?, List<T>> toList(T defaultValue) {
    return Collectors.collectingAndThen(
              Collectors.toList(), 
              l -> l.isEmpty() ? Collections.singletonList(defaultValue) : l
           );
}