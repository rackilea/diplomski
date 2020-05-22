public void EmployeeEncyrptedZipFileDownload(HttpServletResponse response, @RequestParam(value = "id", required = true) int employeeId) throws IOException, ZipException
{
    //Prepare text file contents
    String fileContent = "Hallo Welt";

    response.setContentType("application/zip");
    response.setHeader("Content-Disposition", "attachment;filename=test.zip");

    final StringBuilder sb = new StringBuilder(fileContent);
    final ZipOutputStream zout = new ZipOutputStream(response.getOutputStream());

    ZipParameters zipParameters = new ZipParameters();
    zipParameters.setSourceExternalStream(true);
    zipParameters.setFileNameInZip("mytext.txt");

    zout.putNextEntry(null, zipParameters);
    byte[] data = sb.toString().getBytes();
    zout.write(data, 0, data.length);

    zout.closeEntry();
    zout.finish();
}