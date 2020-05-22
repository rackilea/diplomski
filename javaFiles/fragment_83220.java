Field[] fields = Test_.class.getDeclaredFields();
for (Field field : fields) {
    if (Modifier.isPublic(field.getModifiers())) {
        // For Each Public Field
        try {
            Object obj = field.get(null); // Equivalent to Test_.var1 but you need to cast it
            if (obj instanceof SingularAttribute) {
                System.out.println(obj); // Equivalent to Test_.var1
                System.out.println(SingularAttribute.class.cast(obj).getType()); // Equivalent to Test_.var1.getType()
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}