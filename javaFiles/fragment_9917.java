private static List<Class<?>> findClasses(File directory, String packageName) {
    List<Class<?>> classes = new ArrayList<Class<?>>();
    if (!directory.exists())
        return classes;

    File[] files = directory.listFiles();
    for (File file : files) {
        if (file.isDirectory()) {
            assert !file.getName().contains(".");
            classes.addAll(findClasses(file,
                    (!packageName.equals("") ? packageName + "." : packageName) + file.getName()));
        } else if (file.getName().endsWith(".class"))
            try {
                classes.add(Class
                        .forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
    }
    return classes;
}