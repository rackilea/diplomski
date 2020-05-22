CodeSource src = MyClass.class.getProtectionDomain().getCodeSource();
if (src != null) {
  URL jar = src.getLocation();
  ZipInputStream zip = new ZipInputStream(jar.openStream());
  while(true) {
    ZipEntry e = zip.getNextEntry();
    if (e == null)
      break;
    String name = e.getName();
    if (name.startsWith("path/to/your/dir/")) {
      /* Do something with this entry. */
      ...
    }
  }
} 
else {
  /* Fail... */
}