DemoClass= (Class<Annotation>) Class.forName("com.this.class.DemoClass");
    if (method.isAnnotationPresent(DemoClass)) {
       for (Annotation annotation : method.getAnnotations()) {
       Class<? extends Annotation> annotationType = annotation.annotationType();      
       if (annotationType.getName() == "com.this.class.DemoClass") {
          for (Method annotationMethod : annotationType.getDeclaredMethods()) {
          value= annotationMethod.invoke(annotation, (Object[]) null);
          }
       }
     }