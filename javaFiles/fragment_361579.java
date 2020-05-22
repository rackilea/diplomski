public class JavaCompiler {
    public static void main(String args[]) throws IOException, TimeoutException {
        File dir = new File(System.getProperty("user.dir") + "/src/main/java/");
        System.out.println(compileJavaCode(dir));
    }
    public static String compileJavaCode(File workingDir) throws IOException,      TimeoutException {

        javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
      //    this.createJavaFile(javaCode, javaFileName, workingDir);
      //    JavaFileObject file = new JavaSourceFromString(javaFileName, javaCode);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromStrings(Arrays.asList(System.getProperty("user.dir") + "/src/main/java/Foo.java"));
//    Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

        String diagn = "";
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            diagn += diagnostic.getMessage(null) + "\n";//E.g. cannot find symbol symbol: variable variablename
            diagn += "Error on line " + Long.toString(diagnostic.getLineNumber()) + " in " + diagnostic.getSource().toUri();//E.g. Error on line 22 in ClassName.java
        }
        fileManager.close();
        compiler.run(null, null, null, workingDir.getAbsolutePath() + File.separator + "Foo.java");
        return diagn;
    }
}