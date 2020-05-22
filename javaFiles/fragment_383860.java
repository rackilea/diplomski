// customize these, if you want, null triggers default behavior
DiagnosticListener<JavaFileObject> diagnosticListener = null;
Locale locale = null;

JavaCompiler c = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fm
    = c.getStandardFileManager(diagnosticListener, locale, Charset.defaultCharset());

// define where to store compiled class files - use a temporary directory
Path binaryDirectory = Files.createTempDirectory("compile-test");
fm.setLocation(StandardLocation.CLASS_OUTPUT,
               Collections.singleton(binaryDirectory.toFile()));

JavaCompiler.CompilationTask task = c.getTask(null, fm,
    diagnosticListener, Collections.emptySet(), Collections.emptySet(),
    // to make this a stand-alone example, I use embedded source code
    Collections.singleton(new SimpleJavaFileObject(
        URI.create("string:///Class1.java"), Kind.SOURCE) {
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return "package test;\npublic class Class1 { public class Inner {} }";
            }
        }));
if(task.call()) try {
    URLClassLoader cl = new URLClassLoader(new URL[]{ binaryDirectory.toUri().toURL() });
    Class<?> loadedClass = cl.loadClass("test.Class1");
    System.out.println("loaded "+loadedClass);
    System.out.println("inner classes: "+Arrays.toString(loadedClass.getClasses()));
} catch(ClassNotFoundException ex) {
    ex.printStackTrace();
}