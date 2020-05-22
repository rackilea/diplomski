public <T> void compare(T t, T t2) throws IllegalArgumentException,
                                          IllegalAccessException {
    Field[] fields = t.getClass().getDeclaredFields();
    if (fields != null) {
        for (Field field : fields) {
            if (field.isAnnotationPresent(ComparableField.class)) {
                field.setAccessible(true);
                if ( (field.get(t)).equals(field.get(t2)) )
                    System.out.println("equals");
                field.setAccessible(false);
            }
        }
    }
}