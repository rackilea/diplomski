public Optional<Integer> findToken(Character operator) {
    return tokenList.stream()
            .filter(x ->
                 x.position >= startPosition &&
                 x.position <= endPosition &&
                 x.operator == operator
            )
            .findFirst()
            .map(t -> t.position);
}