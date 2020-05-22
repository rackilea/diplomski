private String tablenameFromFilename(String path) {
  String filename = Paths.get(path).getFileName().toString();
  if (filename.endsWith("out.gz") {
     return "BB_"+ filename.substring(0,filename.indexOf('.')).toUpperCase() + "_IMPORT";
  } else if (filename.endsWith("px.gz")) {
    return "BB_" + filename.substring(0, filename.indexOf('.')).toUpperCase() + "_PX_IMPORT";
  } else {
    throw new RuntimeException("Extension unsupported");
  }
}