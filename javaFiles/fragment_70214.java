public Object readConfig() {
    try {
        // Assume jsonString exists
        return (this.clazz.getDeclaredConstructor(String.class).newInstance(jsonString)); <--- clazz should be getClass()
    } catch (InstantiationException | IllegalAccessException
            | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
        e.printStackTrace();
         <---- missing return statement
    }
}