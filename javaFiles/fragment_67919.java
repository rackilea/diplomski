final Field field = clazz.getDeclaredField(fieldName);
field.setAccessible(true);
final Field modifiersField = Field.class.getDeclaredField("modifiers");
modifiersField.setAccessible(true);
modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

field.set(null, value);