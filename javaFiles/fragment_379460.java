public void generateReport(ActionEvent actionEvent) throws FileNotFoundException {

JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(PopulateBean.createBeanCollection());
Map parameters = new HashMap();

try {
    InputStream is = new FileInputStream(new File("Source path to template.jrxml"));
    OutputStream os=new FileOutputStream(new File("Resulting report.pdf"));

    JasperDesign jasperDesign = JRXmlLoader.load(is);
    JasperReport jasperReport =
        JasperCompileManager.compileReport(jasperDesign);

    JasperPrint jasperPrint =
        JasperFillManager.fillReport(jasperReport, parameters, ds);

    JasperExportManager.exportReportToPdfStream(jasperPrint, os);
} catch (JRException e) {
      e.printStackTrace();
}