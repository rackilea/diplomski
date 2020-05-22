public static void main(String[] args) throws JRException {
    File file = new File("C:\\Test\\src\\report1.jrxml");
    System.out.println("file = "+file.exists());
    JasperDesign _des = JRXmlLoader.load(file);

    _des.setPageHeight(842);
    _des.setPageWidth(595);

    JasperReport _rep = JasperCompileManager.compileReport(_des);
    JasperPrint jasperPrint = JasperFillManager.fillReport(_rep, new HashMap<String, Object>());
    JasperViewer.viewReport(jasperPrint, true);
}