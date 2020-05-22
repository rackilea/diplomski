Class c = ob.getClass();
for (Class c = ob.getClass(); c != null; c = c.getSuperclass()) {
  for (Method method : c.getDeclaredMethods()) {
    if (method.getAnnotation(PostConstruct.class) != null) {
      System.out.println(c.getName() + "." + method.getName());
    }
  }
}