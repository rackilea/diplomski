while(rs.next()){

        String path= rs.getString(2);
    // Create a PdfDocument instance
    PdfDocument doc = new PdfDocument();
    try {
      // Load an existing document
      doc.load(path);
      // Get page count and display it on console output
      System.out.println(
        "Number of pages in sample_doc1.pdf is " +
        doc.getPageCount());
      // Close document
      doc.close();      
    } catch (IOException | PdfException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
}