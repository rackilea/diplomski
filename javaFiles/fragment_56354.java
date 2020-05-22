//create the context object and the font extension
SimpleJasperReportsContext jasperReportsContext = new SimpleJasperReportsContext();

SimpleFontFamily fontFamily = new SimpleFontFamily(jasperReportsContext);
fontFamily.setName("family name");//to be used in reports as fontName
fontFamily.setPdfEmbedded(true);
fontFamily.setPdfEncoding("Identity-H");

SimpleFontFace regular = new SimpleFontFace(jasperReportsContext);
regular.setTtf("font ttf path");
fontFamily.setNormalFace(regular);

jasperReportsContext.setExtensions(FontFamily.class, Arrays.asList(fontFamily));

//use the context when filling and exporting reports
//note that there are variations here depending on the API you use for filling and exporting
JasperPrint jasperPrint = JasperFillManager.getInstance(jasperReportsContext).fill(jasperReport, params);
...
JasperExportManager.getInstance(jasperReportsContext).exportToPdf(jasperPrint);
...
JRPdfExporter exporter = new JRPdfExporter(jasperReportsContext);