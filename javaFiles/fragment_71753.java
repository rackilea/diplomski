ClassLoader cl = Thread.currentThread().getContextClassLoader();
String classPath = ((weblogic.utils.classloaders.GenericClassLoader)cl).getClassPath();

// Once we have a classpath it's standard procedure
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager sfm = compiler.getStandardFileManager(null, null, null);
List<String> optionList = new ArrayList<String>();
optionList.addAll(Arrays.asList("-classpath", classPath));
compiler.getTask(null, sfm, null, optionList, null, sources).call();