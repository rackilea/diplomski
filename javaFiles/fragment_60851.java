class Property<T> {

    public T value;
    private final Class<T> clazz;

    public Property(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }       

    @SuppressWarnings("unchecked")
    public void setValue(String input) {
        if (clazz.isAssignableFrom(String.class)) {
            value = (T) input;
        } else if (clazz.isAssignableFrom(Integer.class)) {
            value = (T) Integer.valueOf(input);
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            value = (T) Boolean.valueOf(input);
        } else if (clazz.isAssignableFrom(Double.class)) {
            value = (T) Double.valueOf(input);
        } else {
            throw new IllegalArgumentException("Bad type.");
        }
    }
}