// for super classes, use recursion.
for(Field f : obj.getClass().getDeclaredFields()) {
    Class type = f.getType();
    if (type == String.class || type == TranslatableText.class) {
        Object value = f.get(object);
        if (value != null)
            map.put(f.getName(), value.toString());
    }