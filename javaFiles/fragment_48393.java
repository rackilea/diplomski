String path ="C:\\Users\\pc\\workspace\\asttester\\src\\test\\Apple.java";
    File file = new File(path);
    String str = Util.readFileToString(file);

    ASTParser parser = ASTParser.newParser(AST.JLS8);
    parser.setResolveBindings(true);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);

    parser.setBindingsRecovery(true);

    Map options = JavaCore.getOptions();
    parser.setCompilerOptions(options);

    String unitName = "Apple.java";
    parser.setUnitName(unitName);

    String[] sources = { "C:\\Users\\pc\\workspace\\asttester\\src" }; 
    String[] classpath = {"C:\\Program Files\\Java\\jre1.8.0_25\\lib\\rt.jar"};

    // sources is the source dir of all your java files
    // classpath is the java jar containing all the needed classes
    parser.setEnvironment(classpath, sources, new String[] { "UTF-8"}, true);
    parser.setSource(str.toCharArray());

    CompilationUnit cu = (CompilationUnit) parser.createAST(null);