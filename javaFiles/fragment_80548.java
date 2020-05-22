DynamicJavaFileObject composer = new DynamicJavaFileObject("com.xxx","ClassName");

composer.setSuperclass("superclass");
composer.addImport(GWT.class.getCanonicalName());

SourceWriter writer = composer.getSourceWriter();

writer.println("public String test(){return \"test\"}");

writer.commit(logger);