ClassesTransformer<JavaMethod> methods = new AbstractClassesTransformer<JavaMethod>("methods") {
    @Override
    public Iterable<JavaMethod> doTransform(JavaClasses javaClasses) {
        Set<JavaMethod> allMethods = new HashSet<>();
        for (JavaClass javaClass : javaClasses) {
            allMethods.addAll(javaClass.getMethods());
        }
        return allMethods;
    }
};