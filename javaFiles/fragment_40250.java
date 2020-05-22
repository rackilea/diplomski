Class clazz = Demo.class

for(Method method : clazz.getMethods()) {
  for(Annotation annotation : method.getDeclaredAnnotations()) {
     System.out.println(annotation );
  }
}