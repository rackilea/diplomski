List<Method> methods1 = scanResult
    .getSubclasses("pkg.BaseComponent").stream()
    .flatMap(c -> c.getMethodInfo().stream())
    .filter(m -> m.hasAnnotation("pkg.MyAnnotation"))
    .map(MethodInfo::loadClassAndGetMethod)
    .collect(Collectors.toList());