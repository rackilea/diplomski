ServletOutputStream fileOut = null;
        try {
....
Workbook wb = new XSSFWorkbook();
Sheet fullReport = wb.createSheet("Full Report");
....
response.setContentType("application/vnd.ms-excel");
            fileOut = response.getOutputStream();
            //fileOut.
            wb.write(fileOut);
            wb.close();
            fileOut.close();
            fileOut.flush();
        } catch (Exception e) {
<... log attempt ...>
}