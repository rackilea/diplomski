@RequestMapping(value = "/reports/{dd}/{mm}/{yyyy}", method = RequestMethod.GET)
@ResponseBody
private void excelReport(@PathVariable("dd") Integer day,
                         @PathVariable("mm") Integer month,
                         @PathVariable("yyyy") Integer year,
                         HttpServletResponse response) {
    System.out.println("excelReport"); 
    //Search from your specific location the right report
    File file = //Your file  
    String mimeType = URLConnection.guessContentTypeFromName(file.getName());
    response.setContentType(mimeType);
    response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
    response.setContentLength((int) file.length());
    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    FileCopyUtils.copy(inputStream, response.getOutputStream());
}