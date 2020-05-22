/**
   * Lookup the definition of a class.
   * 
   * Lookup order: 1. Search in the current file: within the current class scope upwards to the
   * root. 2. Search laterally across files with the same package value for implicitly included
   * classes. 3. Check all import statements.
   * 
   * @param pack
   *          Current package ex "edu.illinois.crhc"
   * @param scope
   *          Current scope ex "Test.InnerClass"
   * @param identifier
   *          The partial class name to search for
   * @return ClassTree the definition of this class if found
   */
  ClassLookup lookupClass(CompilationUnitTree packTree, String scope, String identifier) {
    dumpClassTable();
    String pack = packTree.getPackageName().toString();
    System.out.println("Looking for class " + pack + " - " + scope + " - " + identifier);
    // Search nested scope and within same package
    HashMap<String, ClassTree> packClasses = classDefinitions.get(pack);
    if (packClasses != null) {
      String[] scopeWalk = scope.split("\\.");
      for (int i = scopeWalk.length; i >= 0; i--) {
        StringBuilder scopeTest = new StringBuilder();
        for (int j = 0; j < i; j++) {
          scopeTest.append(scopeWalk[j] + ".");
        }
        scopeTest.append(identifier);
        System.out.println("Testing scope " + pack + " - " + scopeTest.toString());
        if (packClasses.containsKey(scopeTest.toString())) {
          return new ClassLookup(packClasses.get(scopeTest.toString()), pack.replace(".", "/")
              + "/" + scopeTest.toString().replace(".", "$"));
        }
      }
    }
    /*
     * Check if fully-qualified identifier (foo.bar.Widget) is used. This needs to search all
     * combinations of package and class nesting.
     */
    StringBuilder packTest = new StringBuilder();
    String[] qualifiedName = identifier.split("\\.");
    for (int i = 0; i < qualifiedName.length - 1; i++) {
      packTest.append(qualifiedName[i]);
      if (i != qualifiedName.length - 2) {
        packTest.append(".");
      }
    }
    String clazz = qualifiedName[qualifiedName.length - 1];
    System.out.println("Testing absolute identifier: " + packTest.toString() + " " + clazz);
    if (classDefinitions.containsKey(packTest.toString())) {
      HashMap<String, ClassTree> foundPack = classDefinitions.get(packTest.toString());
      if (foundPack.containsKey(clazz)) {
        return new ClassLookup(foundPack.get(clazz), packTest.toString().replace(".", "/") + "/"
            + clazz.replace(".", "$"));
      }
    }

    /*
     * Search import statements. Last identifier segment must be class name. Search all of the
     * packages for the identifier by splitting off the class name. a.b.c.Tree Tree.Branch
     * Tree.Branch.Leaf
     */
    for (ImportTree imp : currentPackTree.getImports()) {
      pack = imp.getQualifiedIdentifier().toString();
      System.out.println(pack);
      String[] importName = pack.split("\\.");
      // Split off class name.
      // TODO: (edge case) no package
      StringBuilder importTest = new StringBuilder();
      for (int i = 0; i < importName.length - 1; i++) {
        importTest.append(importName[i]);
        if (i != importName.length - 2) {
          importTest.append(".");
        }
      }
      // See if the last import segment is * or matches the first segment of the identifier.

      System.out.println("Testing globally " + importTest.toString() + " - " + identifier);
      if (classDefinitions.containsKey(importTest.toString())) {
        HashMap<String, ClassTree> foundPack = classDefinitions.get(importTest.toString());
        String[] identifierParts = identifier.split(".");
        String importClass = importName[importName.length-1];
        if (importClass.equals("*") || identifierParts[0].equals(importClass)) {
          if (foundPack.containsKey(identifier)) {
            return new ClassLookup(foundPack.get(identifier), importTest.toString().replace(".", "/")
                + "/" + identifier.replace(".", "$"));
          }
        }
      }
    }

    return null;
  }