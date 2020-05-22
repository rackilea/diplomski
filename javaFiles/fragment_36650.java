private static final List<Class<? extends Exception>> SOME_ERRORS;
static{
    List<Class< ? extends Exception>> errors = new ArrayList<>();
    errors.add(NumberFormatException.class);
    errors.add(NullPointerException.class);

    SOME_ERRORS = Collections.unmodifiableList(errors);
}