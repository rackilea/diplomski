public static Set<Class<? extends Model>> getAllEntities() throws ClassNotFoundException {

    Set<Class<? extends Model>> allEntities = new HashSet<>();
    Set<ClassPath.ClassInfo> classes;
    try {
        classes = ClassPath.from(Application.class.getClassLoader()).getTopLevelClassesRecursive("me.factorify.server");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    for(ClassPath.ClassInfo classInfo : classes) {
        // NEW LINE
        Class<?> clazz = Application.class.getClassLoader().loadClass(classInfo.getName());

        //ORIGINAL LINE Class<?> clazz = classInfo.load();

        if (Model.class.isAssignableFrom(clazz)){
            allEntities.add((Class<? extends Model>) clazz);
        }
    }
    return allEntities;
}