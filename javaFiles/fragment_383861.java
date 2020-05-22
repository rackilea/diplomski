public static Class<?> compile(
    DiagnosticListener<JavaFileObject> diagnosticListener,
    Locale locale, String sourceFile) throws IOException, ClassNotFoundException {

    JavaCompiler c = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fm
        = c.getStandardFileManager(diagnosticListener, locale, Charset.defaultCharset());

    // define where to store compiled class files - use a temporary directory
    Path binaryDirectory = Files.createTempDirectory("compile-test");
    fm.setLocation(StandardLocation.CLASS_OUTPUT,
                   Collections.singleton(binaryDirectory.toFile()));

    JavaCompiler.CompilationTask task = c.getTask(null, fm,
        diagnosticListener, Collections.emptySet(), Collections.emptySet(),
        fm.getJavaFileObjects(new File(sourceFile)));
    if(task.call()) {
        Class<?> clazz = null;
        URLClassLoader cl = new URLClassLoader(new URL[]{binaryDirectory.toUri().toURL()});
        for(JavaFileObject o: fm.list(
            StandardLocation.CLASS_OUTPUT, "", Collections.singleton(Kind.CLASS), true)) {

            String s = binaryDirectory.toUri().relativize(o.toUri()).toString();
            s = s.substring(0, s.length()-6).replace('/', '.');
            clazz = cl.loadClass(s);
            while(clazz.getDeclaringClass() != null) clazz = clazz.getDeclaringClass();
            if(Modifier.isPublic(clazz.getModifiers())) break;
        }
        if(clazz != null) return clazz;
        throw new ClassNotFoundException(null,
            new NoSuchElementException("no top level class generated"));
    }
    throw new ClassNotFoundException(null,
        new NoSuchElementException("compilation failed"));
}