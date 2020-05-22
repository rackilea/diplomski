private void checksIfNull(Object... values) throws NullPointerException {
    for (Object value: values) {
        if (value == null) {
            throw new NullPointerException("Attempted to pass a null object");
        }
    }
}