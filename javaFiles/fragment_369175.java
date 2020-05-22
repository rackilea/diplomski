for(Class c : subclasses) {
  for(Field f : c.getFields())
    // Do stuff with the fields
  for(Method m : c.getMethods())
    // Do stuff with the methods
}