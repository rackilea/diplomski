private final Map<?, ?> target;

@Override
protected Object getActualFieldValue(String field) {
    return this.target.get(field);
}