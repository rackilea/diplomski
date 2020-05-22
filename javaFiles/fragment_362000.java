public String getRangeMin() {
    if (!property.field.isAnnotationPresent(Range.class)) {
        return null;
    }
    return property.field.getAnnotation(Range.class).min();
}