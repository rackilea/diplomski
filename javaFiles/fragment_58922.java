private static void setDefault(String newDefault) throws Exception {
  Field staticField = SomeFinalClass.class.getDeclaredField("CONSTANT");
  setValue(null, staticField, newDefault);
}

protected static void setValue(Object owner, Field field, Object value) throws Exception {
  makeModifiable(field);
  field.set(owner, value);
}

/**
 * Force the field to be modifiable and accessible.
 */
protected static void makeModifiable(Field nameField) throws Exception {
  nameField.setAccessible(true);
  int modifiers = nameField.getModifiers();
  Field modifierField = nameField.getClass().getDeclaredField("modifiers");
  modifiers = modifiers & ~Modifier.FINAL;
  modifierField.setAccessible(true);
  modifierField.setInt(nameField, modifiers);
}