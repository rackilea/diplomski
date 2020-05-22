@RequestMapping(value ="/gettemplate", method = RequestMethod.GET)
@ResponseBody
public void getExcelTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("content-disposition", "attachment; filename=TestFile.xlsx");

    InputStream fis = getClass().getClassLoader().getResourceAsStream("templates/TestFile.xlsx");
    int x = fis.available();
    byte byteArray[] = new byte[x];
    logger.info(" File size :"+byteArray.length);
    fis.read(byteArray);

    response.getOutputStream().write(byteArray);
    response.flushBuffer();
    fis.close();
}