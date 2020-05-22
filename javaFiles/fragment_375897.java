for (Property property : entity.getPropertyList()) {
  // Find the list property by name.
  if (property.getName().equals(name)) {
    for (Value value : property.getValue().getListValueList()) {
      // Print each string value from the list value.
      System.out.println(value.getStringValue());
    }
  }
}