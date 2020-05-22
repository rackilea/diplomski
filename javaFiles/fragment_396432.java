Map<Integer, String> valueToStringMap = new HashMap<>();
for (Field field : Foo.class.getFields()) {
    int modifiers = field.getModifiers();
    if (field.getType() == Integer.class && Modifier.isPublic(modifiers)
        && Modifier.isStatic(modifiers)) {
        valueToStringMap.put((Integer) field.get(null), field.getName());
    }
}