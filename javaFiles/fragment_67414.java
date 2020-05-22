ZipFile file = new ZipFile("file.zip");
ZipInputStream zis = searchImage("foo.png", file);

public InputStream searchImage(String name, ZipFile file) {
  for (ZipEntry e : Collections.list(file.entries())) {
    if (e.getName().endsWith(name)) {
      return file.getInputStream(e);
    }
  }
  return null;
}