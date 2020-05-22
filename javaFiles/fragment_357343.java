@RequestMapping(value = "/movies/ticket", method = RequestMethod.GET)//stampa ticket
public void getTicket(@RequestParam(value="id")int id, int numb, HttpServletResponse response) throws Exception {
    //Use the complied file,you do not need to compile the jrxml everytime
    //Furthermore since its in src (I would have use class loader)
    String fileJasper = "/home/salvador/workspace/serverMovies/src/main/webapp/resources/Jasper/ticket.jasper";
    JasperReport report = (JasperReport)JRLoader.loadObject(fileJasper);
    JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, getDataSource(id));
    response.setContentType("application/pdf");
    response.setHeader("Content-disposition", "attachment; filename=report.pdf");
    JasperExportManager.exportReportToPdfStream(jasperPrint, response);
}