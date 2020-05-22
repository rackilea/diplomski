private static Object getPrivateStatic(Class clazz, String f) throws Exception {
        try {
            Field field = clazz.getDeclaredField(f);
            field.setAccessible(true);
            return field.get(null);
        }
        catch (NoSuchFieldException e) {
            // Throw a more helpful exception.
            throw new NoSuchFieldException(
                "Could not find field named '" + f + "' in class '" + clazz +
                "'.  All fields: " + Arrays.asList(clazz.getDeclaredFields()));
        }
    }