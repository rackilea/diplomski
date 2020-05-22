public static Collection<Method> getAllMethods(Class clazz,
                boolean includeAllPackageAndPrivateMethodsOfSuperclasses,
                boolean includeOverridenAndHidden) {

    Predicate<Method> include = m -> !m.isBridge() && !m.isSynthetic() &&
         Character.isJavaIdentifierStart(m.getName().charAt(0))
      && m.getName().chars().skip(1).allMatch(Character::isJavaIdentifierPart);

    Set<Method> methods = new LinkedHashSet<>();
    Collections.addAll(methods, clazz.getMethods());
    methods.removeIf(include.negate());
    Stream.of(clazz.getDeclaredMethods()).filter(include).forEach(methods::add);

    final int access=Modifier.PUBLIC|Modifier.PROTECTED|Modifier.PRIVATE;

    Package p = clazz.getPackage();
    if(!includeAllPackageAndPrivateMethodsOfSuperclasses) {
        int pass = includeOverridenAndHidden?
            Modifier.PUBLIC|Modifier.PROTECTED: Modifier.PROTECTED;
        include = include.and(m -> { int mod = m.getModifiers();
            return (mod&pass)!=0
                || (mod&access)==0 && m.getDeclaringClass().getPackage()==p;
        });
    }
    if(!includeOverridenAndHidden) {
        Map<Object,Set<Package>> types = new HashMap<>();
        final Set<Package> pkgIndependent = Collections.emptySet();
        for(Method m: methods) {
            int acc=m.getModifiers()&access;
            if(acc==Modifier.PRIVATE) continue;
            if(acc!=0) types.put(methodKey(m), pkgIndependent);
            else types.computeIfAbsent(methodKey(m),x->new HashSet<>()).add(p);
        }
        include = include.and(m -> { int acc = m.getModifiers()&access;
            return acc!=0? acc==Modifier.PRIVATE
                    || types.putIfAbsent(methodKey(m), pkgIndependent)==null:
                noPkgOverride(m, types, pkgIndependent);
        });
    }
    for(clazz=clazz.getSuperclass(); clazz!=null; clazz=clazz.getSuperclass())
        Stream.of(clazz.getDeclaredMethods()).filter(include).forEach(methods::add);
    return methods;
}
static boolean noPkgOverride(
        Method m, Map<Object,Set<Package>> types, Set<Package> pkgIndependent) {
    Set<Package> pkg = types.computeIfAbsent(methodKey(m), key -> new HashSet<>());
    return pkg!=pkgIndependent && pkg.add(m.getDeclaringClass().getPackage());
}
private static Object methodKey(Method m) {
    return Arrays.asList(m.getName(),
        MethodType.methodType(m.getReturnType(), m.getParameterTypes()));
}