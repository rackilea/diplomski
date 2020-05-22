List<Celsius> celsius;
final List<Fahrenheit> fahrenheit = celsius.stream()
                                           .map(c -> convert(c))
                                           .collect(Collectors.toList());

private static Fahrenheit convert(Celsius c) {