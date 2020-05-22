public class PdfGenerator {

public byte[]  generateJasperReportPDF(HttpServletRequest httpServletRequest, String jasperReportName, ByteArrayOutputStream outputStream, Map parametros) {
    JRPdfExporter exporter = new JRPdfExporter();
    try {
        String reportLocation = httpServletRequest.getRealPath("/") +"resources\\jasper\\" + jasperReportName + ".jrxml";

        InputStream jrxmlInput = new FileInputStream(new File(reportLocation)); 
        //this.getClass().getClassLoader().getResource("data.jrxml").openStream();
        JasperDesign design = JRXmlLoader.load(jrxmlInput);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        //System.out.println("Report compiled");

        //JasperReport jasperReport = JasperCompileManager.compileReport(reportLocation);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, HibernateUtils.currentSession().connection()); // datasource Service

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        exporter.exportReport();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error in generate Report..."+e);
    } finally {
    }
    return outputStream.toByteArray();
}
}