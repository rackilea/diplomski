Set<Field> fields = reflections.getFieldsAnnotatedWith(Searchable.class);
Set<Field> wanted = new HashSet<Field>();
for (Field field : fields) {
    Searchable annotation = field.getAnnotation(Searchable.class);
    if (Arrays.asList(annotation.types).contains(SearchType.ALL)) {
        wanted.add(field);
    }
}