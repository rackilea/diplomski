private void exportXMI(String absuloteTargetFolderPath) {
    // change MyLanguage with your language name
    Injector injector = new MyLanguageStandaloneSetup()
            .createInjectorAndDoEMFRegistration();
    XtextResourceSet resourceSet = injector
            .getInstance(XtextResourceSet.class);

    // .ext ist the extension of the model file
    String inputURI = "file:///" + absuloteTargetFolderPath + "/MyFile.ext";
    String outputURI = "file:///" + absuloteTargetFolderPath + "/MyFile.xmi";
    URI uri = URI.createURI(inputURI);
    Resource xtextResource = resourceSet.getResource(uri, true);

    EcoreUtil.resolveAll(xtextResource);

    Resource xmiResource = resourceSet
            .createResource(URI.createURI(outputURI));
    xmiResource.getContents().add(xtextResource.getContents().get(0));
    try {
        xmiResource.save(null);
    } catch (IOException e) {
        e.printStackTrace();
    }
}