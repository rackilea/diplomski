JRExporter exporter = new JRExporter();
    ByteArrayOutputStream os=new ByteArrayOutputStream();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
    exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
    exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BACKGROUND, Boolean.FALSE);
    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);


    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "inline;filename=" + "one.xls");
    response.getOutputStream().write(os.toByteArray());