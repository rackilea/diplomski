private void invokeSetters(Object o) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    System.out.println("INVOKING THE OBJECT " + o.getClass().toString());
      for (Field f : o.getClass().getDeclaredFields()) {
        System.out.println("NOW IN THE FIELD: " + f.getName());
        f.setAccessible(true);
        Object obj = null;
        if (isUserDefined(f.getType()) && f.get(o) == null) {
            System.out.println("FIELD is USER DEFINED AND NULL");
            Class c = Class.forName(f.getType().getName());
            System.out.println("CLASS IS " + c.getName());
            obj = c.getConstructor().newInstance();
            System.out.println("GOING INSIDE " + obj.toString() + " NOW.");
            invokeSetters(obj);
        }
        if (obj != null) {
            Method setter = getSetterMethod(o, f);
            System.out.println("IM IN PARENT OBJECT " + o + " AND INVOKING METHOD " + setter.getName() + " WITH PARAMETER " + obj.toString());
            setter.invoke(o, obj);
            System.out.println("METHOD WAS INVOKED");
        }
      }
    }