String storeUrl = "file:///C:/Users/JimStandard/Desktop/Test.odt";
XStorable xStorable = (XStorable) UnoRuntime.queryInterface(
    XStorable.class, xTextDocument);
PropertyValue[] storeProps = new PropertyValue[1];
storeProps[0] = new PropertyValue();
storeProps[0].Name = "Overwrite";
storeProps[0].Value = new Boolean(true);
try {
    xStorable.storeToURL(storeUrl, storeProps);
} catch (com.sun.star.io.IOException ex) {
    ex.printStackTrace(System.err);
    System.exit(1);
}  
try {
    URL url = new URL(storeUrl);  // this is 
    Path testPath = Paths.get(url.toURI());
    byte[] data = Files.readAllBytes(testPath);
    System.out.println("Length = " + data.length);
} catch (java.io.IOException ex) {
    ex.printStackTrace(System.err);
    System.exit(1);
} catch (URISyntaxException ex) {
    ex.printStackTrace(System.err);
    System.exit(1);
}