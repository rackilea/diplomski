byte[] pdfFile = null;
    String realPath = context.getRealPath("/images/");
    try {
        JasperPrint print = service.loadReceipt(RECEIPT_NAME, paymentId, realPath);
        pdfFile = JasperExportManager.exportReportToPdf(print);
        OutputStream outStream = res.getOutputStream();
        res.setContentType("application/pdf");
        res.addHeader("Content-disposition", "inline; filename=Receipt.pdf");
        outStream.write(pdfFile);
        outStream.flush();
        outStream.close();
}