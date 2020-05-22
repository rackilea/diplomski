List<String> optionList = new ArrayList<String>();
// set compiler's classpath to be same as the runtime's
optionList.addAll(Arrays.asList("-classpath",System.getProperty("java.class.path")));

// any other options you want
optionList.addAll(Arrays.asList(options));

JavaCompiler.CompilationTask task = compiler.getTask(out,jfm,diagnostics,optionList,null,jfos);