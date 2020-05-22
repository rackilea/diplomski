Class c = ob.getClass();
for (Method method : c.getDeclaredMethods()) {
  if (method.getAnnotation(PostConstruct.class) != null) {
    System.out.println(method.getName());
  }
}