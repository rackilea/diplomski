// based on example from github page
try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages("pkg").scan()) {    
    // probably could be changed to some other code that would return methods directly from class graph, but it does the same job.
    List<Class<?>> classes = scanResult
        .getClassesWithMethodAnnotation("pkg.MyAnnotation")
        .filter(clazz -> clazz.extendsSuperclass("pkg.BaseComponent"))
        .loadClasses();
    List<Method> methods = classes.stream()
        .flatMap(c -> Stream.of(c.getMethods()))
        .filter(m -> m.isAnnotationPresent(MyAnnotation.class))
        .collect(Collectors.toList());
}