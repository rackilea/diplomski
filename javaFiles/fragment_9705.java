Person personobject = new Person(6, "Test");
MaxLength maxLengthAnnotation;
Method[] methods = personobject.getClass().getDeclaredMethods();
for (Method method : methods) {
if (method.getName().startsWith("get")) {
    // check added to avoid run time exception
    if(method.isAnnotationPresent(MaxLength.class)) {
        maxLengthAnnotation = method.getAnnotation(MaxLength.class);
        System.out.println(method.getName().substring(3) + " " + maxLengthAnnotation.length());
    };
  }
}