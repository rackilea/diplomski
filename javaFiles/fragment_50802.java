@RequestMapping(value="/report", params = {"objectid"}, method = { RequestMethod.GET })
public void getReport(HttpServletResponse response, @RequestParam(value = "objectid") long objectid){
    Object object = objectDAOFactory.getObjectDAO().loadById(objectid);

    ObjectDataSource dataSource = new ObjectDataSource(object);

    JasperPrint jasperPrint = getObjectPdf("pdf/ObjectReport.jrxml", new HashMap<String, Object>(), dataSource);

    sendPdfResponse(response, jasperPrint, "Object-" + object.getId());
}

public JasperPrint getObjectPdf(String path, Map<String, Object> parameters, JRDataSource dataSource) {
    JasperPrint jasperPrint = null;

    InputStream inStream = null;
    try {
        inStream = getClass().getClassLoader().getResourceAsStream(path);
        JasperDesign jasperDesign = JRXmlLoader.load(inStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    } catch (JRException jre) {
        logger.error("Error creating Pdf", jre);
    } finally {
        if (inStream != null) {
            try {
                inStream.close();
            } catch (IOException e) {
                logger.error("Error closing stream", e);
            }
        }
    }

    return jasperPrint;
}

public static void sendPdfResponse(HttpServletResponse response, JasperPrint jasperPrint, String fileName){

    //Remove all whitespace from file name
    fileName.replaceAll("\\s","");

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    } catch (JRException e1) {
        e1.printStackTrace();
    }

    byte[] data = out.toByteArray();

    response.setContentType("application/pdf");
    //To make it a download change "inline" to "attachment"
    response.setHeader("Content-disposition", "inline; filename=" + fileName + ".pdf");
    response.setContentLength(data.length);

    try {
        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}