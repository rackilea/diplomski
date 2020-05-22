public static Set<Method> getAllMethods(Class<?> cl) {
    Set<Method> methods=new LinkedHashSet<>();
    Collections.addAll(methods, cl.getMethods());
    Map<Object,Set<Package>> types=new HashMap<>();
    final Set<Package> pkgIndependent = Collections.emptySet();
    for(Method m: methods) types.put(methodKey(m), pkgIndependent);
    for(Class<?> current=cl; current!=null; current=current.getSuperclass()) {
        for(Method m: current.getDeclaredMethods()) {
            final int mod = m.getModifiers(),
                access=Modifier.PUBLIC|Modifier.PROTECTED|Modifier.PRIVATE;
            if(!Modifier.isStatic(mod)) switch(mod&access) {
                case Modifier.PUBLIC: continue;
                default:
                    Set<Package> pkg=
                        types.computeIfAbsent(methodKey(m), key -> new HashSet<>());
                    if(pkg!=pkgIndependent && pkg.add(current.getPackage())) break;
                    else continue;
                case Modifier.PROTECTED:
                    if(types.putIfAbsent(methodKey(m), pkgIndependent)!=null) continue;
                    // otherwise fall-through
                case Modifier.PRIVATE:
            }
            methods.add(m);
        }
    }
    return methods;
}

private static Object methodKey(Method m) {
    return Arrays.asList(m.getName(),
        MethodType.methodType(m.getReturnType(), m.getParameterTypes()));
}