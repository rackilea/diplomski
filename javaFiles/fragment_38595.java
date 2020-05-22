public static <T> List<T> readTSV(String fileName, Class<T> c) throws InstantiationException, IllegalAccessException, IntrospectionException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
    List<T> list = new ArrayList<T>(); //error.
    List<String> properties = getBeanProperties(c);
    Collections.sort(properties);

    // loop through all rows of the TSV and set each value
    while(/*read rows in tsv*/) {
        T obj = c.newInstance();
        for(int i=0;i<properties.size();i++) {
            setProperty(obj, properties.get(i), /* get row column [i] */);
        }
        list.add(obj);
    }

    return list;
}


public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
    List<Class1> hm1 = readTSV("firstFile.tsv", Class1.class);
    System.out.println(hm1);

    List<Class2> hm2 = readTSV("firstFile.tsv", Class2.class);
    System.out.println(hm2);

}

public static void setProperty(Object obj, String propName, Object value) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    String setterName = "set" + propName.substring(0, 1).toUpperCase()
            + propName.substring(1);

    Field field = obj.getClass().getDeclaredField(propName);
    if(Modifier.isPrivate(field.getModifiers())) {
        Method method = obj.getClass().getMethod(setterName, field.getType());
        method.invoke(obj, value);
    } else {
        field.set(obj, value);
    }
}

public static List<String> getBeanProperties(Class<?> cl) {
    List<String> properties = new ArrayList<String>();
    // check all declared fields
    for (Field field : cl.getDeclaredFields()) {
        // if field is private then look for setters/getters
        if (Modifier.isPrivate(field.getModifiers())) {
            // changing 1st letter to upper case
            String name = field.getName();
            String upperCaseName = name.substring(0, 1).toUpperCase()
                    + name.substring(1);
            // and have getter and setter
            try {
                String simpleType = field.getType().getSimpleName();
                //for boolean property methods should be isProperty and setProperty(propertyType)
                if (simpleType.equals("Boolean") || simpleType.equals("boolean")) {
                    if ((cl.getDeclaredMethod("is" + upperCaseName) != null)
                            && (cl.getDeclaredMethod("set" + upperCaseName,
                                    field.getType()) != null)) {
                    }
                    properties.add(name);
                } 
                //for not boolean property methods should be getProperty and setProperty(propertyType)
                else {
                    if ((cl.getDeclaredMethod("get" + upperCaseName) != null)
                            && (cl.getDeclaredMethod("set" + upperCaseName,
                                    field.getType()) != null)) {
                    }
                    properties.add(name);
                }
            } catch (NoSuchMethodException | SecurityException e) {
                // if there is no method nothing bad will happen
            }
        } else {
            // Accessible property that isnt defined by the jre
            if(!field.isSynthetic()) {
                properties.add(field.getName());
            }
        }
    }
    return properties;
}