public static class MethodInfo {
    Class fromClass;
    ArrayList<Method> methods = new ArrayList<Method>();

    public MethodInfo(Class fromClass) {
        this.fromClass = fromClass;
    }
}

public static HashMap<String, MethodInfo>
        findOverloadedMethods(String packageToScan, boolean declaredInClass){

    Set<Class<?>> allClasses = findAllClassesInPackage(packageToScan);
    System.out.println("Number of Classes in "+ packageToScan 
                       +" = " + allClasses.size());

    HashMap<String, MethodInfo> map = new HashMap<String, MethodInfo>();

    for (Class c : allClasses) {
        try {
            findAllMethodsForClass(c, declaredInClass, map);
        }catch (java.lang.NoClassDefFoundError e){
            //have no idea why some classes throw this NoClassDefFoundError
            System.err.println(c.getName() + ": java.lang.NoClassDefFoundError");
        }
    }

    return map;
}
public static void findAllMethodsForClass(Class c, boolean declaredInClass, 
                                          HashMap<String, MethodInfo> map)
        throws java.lang.NoClassDefFoundError{
    //Set<Method> methods = ReflectionUtils.getAllMethods(c);
    Method[] methods = declaredInClass ? c.getDeclaredMethods(): c.getMethods();

    for (Method method : methods) {
        String key = c.getName() + "." + method.getName();

        if (!map.containsKey(key)) {
            map.put(key, new MethodInfo(c));
        }

        MethodInfo methodInfo = map.get(key);
        methodInfo.methods.add(method);
    }
}
public static Set<Class<?>> findAllClassesInPackage(String packageToScan){
    Reflections reflections = new Reflections(
            new SubTypesScanner(false), new ResourcesScanner(),
            new FilterBuilder().include(FilterBuilder.prefix(packageToScan)));

    return reflections.getSubTypesOf(Object.class);
}

public static void print(HashMap<String, RScanner.MethodInfo> map){
    for (String key : map.keySet()) {
        RScanner.MethodInfo info = map.get(key);
        if (info.methods.size() > 1) {
            // wait method has 3 overloads in Object class
            if (!info.methods.get(0).getName().equals("wait"))
                System.out.println(key + " : " + info.methods.size());
        }
    }
}