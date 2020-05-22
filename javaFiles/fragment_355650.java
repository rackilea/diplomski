Method[] allMethods = c.getDeclaredMethods();
    for (Method m : allMethods) {
        String mname = m.getName();
        if (!mname.startsWith("print") {
            continue;
        }
        Type[] pType = m.getGenericParameterTypes();
        if ((pType.length != 1)
            || !String.class.isAssignableFrom(pType[0].getClass())) {
            continue;
        }
     }