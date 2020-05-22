// Prepare.
String packageName = "com.example.commands";
List<Class<ICommand>> commands = new ArrayList<Class<ICommand>>();
URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

// Filter .class files.
File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.endsWith(".class");
    }
});

// Find classes implementing ICommand.
for (File file : files) {
    String className = file.getName().replaceAll(".class$", "");
    Class<?> cls = Class.forName(packageName + "." + className);
    if (ICommand.class.isAssignableFrom(cls)) {
        commands.add((Class<ICommand>) cls);
    }
}