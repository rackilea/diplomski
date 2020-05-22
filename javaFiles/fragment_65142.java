public String toString() {
    Field[] fields = this.getClass().getDeclaredFields();
    String toString = "";
    for (Field f : fields) {
        try {
            String name = f.getName();
            Object value = f.get(this);
            if (value != null)
                toString += name.toUpperCase() + ": " + value.toString() + "%n";
        }
        catch (IllegalAccessException ex) {
            // either ignore the exception, or add something to the output
            // String to indicate an exception was caught
        }
    }
    return String.format(toString);
}