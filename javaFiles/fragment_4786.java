public List<String> mapToList(final Map<String, String> input) {
    return input.entrySet()
                .stream()
                .map(e -> new StringBuilder(
                             e.getKey().length()
                                     + e.getValue().length()
                                     + 1
                     ).append(e.getKey())
                      .append(' ')
                      .append(e.getValue())
                      .toString()
                )
                .collect(Collectors.toList());
}