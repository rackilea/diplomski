String[] packageNames = { "com.example" };
LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> mapOfpackageMethodParameters = Arrays
    .stream(packageNames)
    .flatMap(packageName -> ClassPath
        .from(ClassLoader.getSystemClassLoader())
        .getTopLevelClassesRecursive(packageName)
        .stream())
    .filter(classInfo -> classInfo.getPackageName().endsWith("test"))
    .map(ClassInfo::load)
    .collect(Collectors.toMap(
        Class::getName,
        clazz -> Arrays
            .stream(clazz.getMethods())
            .collect(Collectors.toMap(
                Method::getName,
                method -> Arrays
                    .stream(method.getParameters())
                    .collect(Collectors.toMap(
                        Parameter::getName,
                        param -> param.getType().toString(),
                        (x, y) -> x, LinkedHashMap::new)),
                (x, y) -> x, LinkedHashMap::new)),
        (x, y) -> x, LinkedHashMap::new));