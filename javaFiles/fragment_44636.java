public static String getResourceContent(
  final String path) throws IOException {
        InputStream stream = YourClass.class.getResourceAsStream("/" + path);
        if (stream != null) {
               return IOUtils.toString(stream);
        } 
    }