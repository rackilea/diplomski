// Get all classes
  List<Class> klasses = ..

  // Filter only those containing
  for(Class k : klasses) {
    if(k.isAnnotationPresent(MainForm.class)) ...
  }