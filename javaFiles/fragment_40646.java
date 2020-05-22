public static void generateReport() throws JRException {
    JRCsvDataSource dataSource = new JRCsvDataSource(JRLoader.getLocationInputStream(csvFileName));
    dataSource.setRecordDelimiter("\r\n");
    dataSource.setUseFirstRowAsHeader(true);
    dataSource.setColumnNames(new String[]{ "USER_NAME", "LAST_ACCESSED", "IS_ACTIVE", "POINTS"});

    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

    JRTextExporter exporter = new JRTextExporter();

    exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
    exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outputFileName);
    exporter.exportReport();
}