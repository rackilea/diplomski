public ArrayList<String> getFieldnames(Object src, int targetValue) {
  final Class<?> myInterfaceClass = MyInterface.class;
  ArrayList<String> fieldNames = new ArrayList<>();
  if (src != null) {
    for (Class<?> currentClass = src.getClass(); currentClass != null; currentClass = currentClass.getSuperclass()) {
      Class<?> [] interfaces = currentClass.getInterfaces();
      if (Arrays.asList(interfaces).contains(myInterfaceClass)) {
        for (Field field : currentClass.getDeclaredFields()) {
          if (field.getType().equals(int.class)) {
            try {
              int value = field.getInt(null);
              if (value == targetValue) {
                fieldNames.add(field.getName());
              }
            } catch (IllegalAccessException ex) {
              // Do nothing. Always comment empty blocks.
            }
          }
        }
      }
    }
  }
  return fieldNames;
}