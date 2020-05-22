task generateXQDoc {
  description = 'Generate XQDocs'

  doLast {
    def sourceDir = 'src/main/ml-modules'
    File targetDir = new File('xqDoc')

    HashMap uriMap = new HashMap();
    uriMap.put(XPathDriver.XPATH_PREFIX, XPathDriver.XPATH_URI);
    controller = new XQDocController(XQDocController.JUL2017);
    controller.setPredefinedFunctionNamespaces(uriMap);

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();

    def xqueryFiles = fileTree(dir: sourceDir, include: '**/*.xq*')
    xqueryFiles.each { file ->

      InputStream is = Files.newInputStream(file));
      XQDocPayload payload = controller.process(is, "");

      String relativePath = new File(sourceDir).toURI().relativize(file.toURI()).getPath();
      File outputFile = new File(targetDir, relativePath)
      outputFile.parentFile.mkdirs()

      outputFile.write(payload.getXQDocXML())
    }
  }
}