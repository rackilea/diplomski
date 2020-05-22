void printFieldsOfClass(Object obj) {
    if (obj == null) {
        return;
    }

    // Deal with collections...
    if (obj instanceof Collection) {
      for (Object o : ((Collection<Object>) obj)) {
        printFieldsOfClass(o);
      }

      return;
    }

    // Otherwise it is a 'simple' object...
    Class<?> mainClass = obj.getClass(); // create instance of the class
    Class<?>[] interfaces =null;
    Object collection = null;
    int isCollection = 0; //1 - for List , 2 -  For Set , 3 - Map
    if(mainClass !=null ){
        interfaces = mainClass.getInterfaces();
    }
    try {
        if(interfaces!=null ){
            for(Class<?> interface1 : interfaces ){



                if(interface1.getName().toString().equals("java.util.List"))                     {
                    isCollection = 1;
                    collection = new ArrayList<Object>();
                }
                else            if(interface1.getName().toString().equals("java.util.Set")){
                    isCollection=2;
                    collection = new HashSet<Object>();
                }
            }
        }