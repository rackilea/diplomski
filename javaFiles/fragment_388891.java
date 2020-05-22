Class ExportReportAction extends ActionSupport {
  public void exportToPdf() { // no return type
    try {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("success PDF FROM STRUTS"));
        document.close(); 
        ServletOutputStream outputStream = response.getOutputStream() ; 
        baos.writeTo(outputStream); 
        response.setHeader("Content-Disposition", "attachment; filename=\"stuReport.pdf\""); 
        response.setContentType("application/pdf"); 
        outputStream.flush(); 
        outputStream.close(); 
    }catch (Exception e) {
        //catch
    }

  } 
}