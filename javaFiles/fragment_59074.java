public JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException, IOException {
    // Create temporary folder to store jasper report as you should not write a resource into your program
    // distribution
    String tempFolderPath = System.getProperty("java.io.tmpdir") + File.separator + "jasperReport";
    File tempFolder = new File(tempFolderPath);
    if (!tempFolder.exists()) {
        tempFolder.mkdirs();
    }
    String jasperFilePath = tempFolderPath + File.separator + fileName + ".jasper";
    File reportFile = new File(jasperFilePath);
    // If compiled file is not found, then compile XML template
    if (!reportFile.exists()) {
        InputStream jRXmlStream = request.getSession().getServletContext().getResourceAsStream
                ("/WEB-INF/jasper/" + fileName + ".jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(jRXmlStream);
        JasperCompileManager.compileReportToFile(jasperDesign, jasperFilePath);
    }
    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
    return jasperReport;
}