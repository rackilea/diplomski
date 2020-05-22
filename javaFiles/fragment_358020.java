private void exportToExcel(HttpServletResponse resp, JasperPrint jasperPrint) throws IOException {
    String reportfilename = tagreport("file") + "repor.xls";
    JExcelApiExporter exporterXLS = new JExcelApiExporter();

    exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
    exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
    exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
    exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
    exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, resp.getOutputStream());
    resp.setHeader("Content-Disposition", "inline;filename="+ reportfilename);
    resp.setContentType("application/vnd.ms-excel");
    try {
        exporterXLS.exportReport();
    } catch (JRException e) {
        e.printStackTrace();
    }
}