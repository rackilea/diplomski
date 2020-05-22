@Override
public String toString() {
    final String eol = System.getProperty("line.separator");
    return m.values()
            .stream()
            .map(Foo::toString)
            .collect(Collectors.joining(eol));
}