public void populateClassDefinitions(String path) {
    Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(path);
    CompilationTask task =
        compiler.getTask(null, fileManager, diagnosticsCollector, null, null, files);
    final JavacTask javacTask = (JavacTask) task;
    parseResult = null;
    try {
      parseResult = javacTask.parse();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    for (CompilationUnitTree tree : parseResult) {
      tree.accept(new TreeScanner<Void, Void>() {
        @Override
        public Void visitCompilationUnit(CompilationUnitTree node, Void p) {
          currentPackage = "";
          ExpressionTree packageName = node.getPackageName();
          if (packageName != null) {
            String packageNameString = String.valueOf(packageName);
            if (packageNameString.length() > 0) {
              currentPackage = packageNameString;
            }
          }
          TreeScanner<Void, String> visitor = new TreeScanner<Void, String>() {
            @Override
            public Void visitClass(ClassTree node, String packagePrefix) {
              if (classDefinitions.get(currentPackage) == null) {
                classDefinitions.put(currentPackage, new HashMap<String, ClassTree>());
              }
              classDefinitions.get(currentPackage).put(packagePrefix + node.getSimpleName(), node);
              return super.visitClass(node, packagePrefix + node.getSimpleName() + ".");
            }
          };
          for (Tree decls : node.getTypeDecls()) {
            decls.accept(visitor, "");
          }
          return super.visitCompilationUnit(node, p);
        }
      }, null);
    }
  }