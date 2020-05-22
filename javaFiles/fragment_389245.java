File sourceFile = new File("SeleniumClass1234.java");
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
compiler.run(null, null, null, sourceFile.getPath());
...

SeleniumRunner sr = (SeleniumRunner) Class.forName("SeleniumClass1234").newInstance();
sr.runSelenium(driver);