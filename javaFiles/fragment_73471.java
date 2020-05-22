private void loadLib(String path, String name) {
  name = System.mapLibraryName(name); // extends name with .dll, .so or .dylib
  InputStream inputStream = null;
  OutputStream outputStream = null;
  try {
    inputStream = getClass().getResourceAsStream("/" + path + name);
    File fileOut = new File("your lib path");
    outputStream = new FileOutputStream(fileOut);
    IOUtils.copy(inputStream, outputStream);

    System.load(fileOut.toString());//loading goes here
  } catch (Exception e) {
    //handle
  } finally {
    if (inputStream != null) {
      try {
        inputStream.close();
      } catch (IOException e) {
        //log
      }
    }
    if (outputStream != null) {
      try {
        outputStream.close();
      } catch (IOException e) {
        //log
      }
    }
  }