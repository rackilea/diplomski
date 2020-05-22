Launcher launcher = new Launcher();
 launcher.addInputResource("./project/src/");

 launcher.buildModel();

 CtModel model = launcher.getModel();

 List<CtType> filteredTypes = model.getElements(
                (CtType type) -> type.getSimpleName().equals("TheClass"));

 CtType functionsClass = filteredTypes.get(0);
 Factory factory = launcher.getFactory();
 for(CtMethod method : (Set<CtMethod<?>>)functionsClass.getMethods()) {
    method.getBody().insertBegin(
          factory.createCodeSnippetStatement(
           "System.out.println(\"" + method.getSimpleName() +  "\")"
    ));
 }

JavaOutputProcessor processor = new JavaOutputProcessor(
     new File("./project/generated"), launcher.createPrettyPrinter());
processor.setFactory(factory);
processor.createJavaFile(functionsClass);