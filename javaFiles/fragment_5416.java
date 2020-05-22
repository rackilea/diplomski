private String getNamedQueryCode(Class<? extends Object> clazz, String namedQueryKey) {
    NamedQueries namedQueriesAnnotation = clazz.getAnnotation(NamedQueries.class);
    NamedQuery[] namedQueryAnnotations = namedQueriesAnnotation.value();

    String code = null;
    for (NamedQuery namedQuery : namedQueryAnnotations) {
        if (namedQuery.name().equals(namedQueryKey)) {
            code = namedQuery.query();
            break;
        }
    }

    if (code == null) {
        if (clazz.getSuperclass().getAnnotation(MappedSuperclass.class) != null) {
            code = getNamedQueryCode(clazz.getSuperclass(), namedQueryKey);
        }
    }

    //if not found
    return code;
}