public Stream<String> descendants(String node) {
    return Stream.concat(
        Stream.of(node),
        flatMap(children(node), this::descendants)
    );
}