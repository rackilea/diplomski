String tmpDir = System.getProperty("java.io.tmpdir");
if (!tmpDir.endsWith("/") && !tmpDir.endsWith("\\"))
    tmpDir += "/";
String resource = "commonDir.dll"; // Adjust accordingly to current OS, omitted for brevity
InputStream is = loader.getResourceAsStream(resource);
if (is == null) {
    // Handle error - resource not found
    return;
}
try {
    FileOutputStream os = new FileOutputStream(tmpDir + resource);
    byte[] buffer = new byte[1024*1024];
    int len = is.read(buffer);
    while (len != -1) {
        os.write(buffer, 0, len);
        len = is.read(buffer);
    }
    os.close();
    is.close();
    System.out.println("Extracted " + resource + " to " + tmpDir);
} catch(IOException ex) {
    // Handle the exception - cannot write to temp directory
    System.out.println("Could not extract resource " + resource + " to " + tmpDir + ": " + ex.getMessage());
}