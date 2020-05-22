InputStream in = new FileInputStream(f);
 XWPFDocument doc = new XWPFDocument(in);
 for (PackagePart p : doc.getAllEmbedds()) {
   POIFSFileSystem poifs = new POIFSFileSystem(p.getInputStream());
   byte[] oleData = IOUtils.toByteArray(
              poifs.createDocumentInputStream("Equation Native"));
 }