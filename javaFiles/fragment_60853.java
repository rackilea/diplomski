class Property<T> {

    T value;    

    @SuppressWarnings("unchecked")
    public void setValue(String input)
    {
        // BEHOLD, MAGIC!
        Class<?> clazz = (Class<?>) getClass().getTypeParameters()[0].getBounds()[0];

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