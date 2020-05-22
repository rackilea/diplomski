List docTypes = Stream.of(DocumentiDiIdentita.class.getFields()).map(this::uncheckedGet).collect(Collectors.toList());

private Object uncheckedGet(Field f) {
    try {
        return f.get(null);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}