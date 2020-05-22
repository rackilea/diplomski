public void myMethod(Object obj) {
  if (obj != null && obj.getClass().isAnnotationPresent(MyAnnotation.class))  {
    processAnnottated(obj);
  } else {
    processNotAnnottated(obj);
  }
}