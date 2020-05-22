JRXlsExporter exporter = new JRXlsExporter();
List<JasperPrint> sheets = new ArrayList<JasperPrint>();
sheets.add(criteriaReportBuilder.toJasperPrint());
sheets.add(reportBuilder.toJasperPrint());
exporter.setExporterInput(SimpleExporterInput.getInstance(sheets));
...