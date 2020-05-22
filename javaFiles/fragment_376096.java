// creating the injector
Injector injector = new MyLanguageStandaloneSetup().createInjectorAndDoEMFRegistration()

// obtain a resource set
XtextResourceSet resourceSet = injector.get(XtextResourceSet.class);

// load file
Resource resource = resourceSet.getResource(URI.create("path/to/file.mylanguage"), true);

// obtain root AST element
MyModel model = (MyModel) resource.getContents().get(0);