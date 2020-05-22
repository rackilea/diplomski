response.setContentType("application/pdf");
Document document = new Document();
try{
    PdfWriter.getInstance(document, 
    response.getOutputStream());
    //pdf generate code