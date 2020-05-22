static byte[] doIt(String message) {
   PDDocument doc = new PDDocument();
   // add the message
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   doc.save(baos);
   return baos.toByteArray();
}

void main(String args[]) {
   byte[] pdf1 = doIt("hello");
   byte[] pdf2 = doIt("world");
   PDFMergerUtility merger = new PDFMergerUtility();
   merger.addSource(new ByteArrayInputStream(pdf1));
   merger.addSource(new ByteArrayInputStream(pdf2));
   // do the rest with the merger
}