Map<? extends Object, Method> map;

Method[] methods = Setters.class.getMethods();
for (Method method : methods) {
  if (method.getName().equals("setCellValue")) {
    map.put(method.getParameterTypes()[0], method);
  }
}