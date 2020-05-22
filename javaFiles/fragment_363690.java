JasperReport jasperReport;
try (InputStream inputStream = JRLoader.getResourceInputStream("image.jrxml")) {
    jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream));
}
Map<String, Object> params = new HashMap<>();
MyBean myBean = new MyBean();

File file = new File(getClass().getClassLoader().getResource("smile.jpg").getFile());
myBean.setLogo(Files.readAllBytes(file.toPath()));

params.put("mybean", myBean);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
File outputFile = new File("output.pdf");
try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
     OutputStream fileOutputStream = new FileOutputStream(outputFile)) {
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
    exporter.setConfiguration(configuration);
    exporter.exportReport();
    byteArrayOutputStream.writeTo(fileOutputStream);
}