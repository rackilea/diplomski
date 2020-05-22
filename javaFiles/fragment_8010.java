public static void writeFileToLiteralData(OutputStream out,
               char fileType, File file, byte[] buffer) throws IOException {
   PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();
   OutputStream pOut = lData.open(out, fileType, file.getName(),
                   new Date(file.lastModified()), buffer);
   FileInputStream in = new FileInputStream(file);
   byte[] buf = new byte[buffer.length];
   int len;

   while ((len = in.read(buf)) > 0) {
         pOut.write(buf, 0, len);
   }

   lData.close();
   in.close();
}