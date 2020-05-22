// get location of the code source
URL url = yourpackage.Main.class.getProtectionDomain().getCodeSource().getLocation();

try {
    // extract directory from code source url
    String root = (new File(url.toURI())).getParentFile().getPath();
    File doc = new File(root, "test.htm");
    // create htm file contents for testing
    FileWriter writer = new FileWriter(doc);
    writer.write("<h1>Test</h1>");
    writer.close();
    // open it in the editor
    editor.setPage(doc.toURI().toURL());
} catch (Exception e) {
    e.printStackTrace();
}