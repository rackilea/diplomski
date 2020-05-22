boolean valid = Stream.of(YourPojoClass.class.getDeclaredFields())
    .filter(f -> !(f.getName().equals("fieldname allowed to be null") || f.getName.equals("the other field name")))
    .allMatch(f -> {
        f.setAccessible(true);
        try {
            return f.get(o) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    });