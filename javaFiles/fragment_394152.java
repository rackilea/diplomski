public static Map<Object, String> getFieldsByValue(Class<?> clz) {
    Map<Object, String> map = new HashMap<Object, String>();
    // Remember: Class.getField() returns only PUBLIC fields
    for (Field field : clz.getFields()) {
        // Check if it's a static variable
        if (Modifier.isStatic(field.getModifiers())) {
            // Add other checks, for example for "integer", if you want.
            try {
                // field.get(null) returns the value of the field for a static field
                map.put(field.get(null), field.getName());
            } catch (IllegalArgumentException e) {
                // should not happen, as we made sure the field is static
            } catch (IllegalAccessException e) {
                // should not happen, as we only listed public fields
            }
        }
    }
    return map;
}