ByteArrayOutputStream bos;
byte[] workbookForLatestBytes;
XSSFXWorkbook workbookForLatestReport;
.
.
.

workbookForLatestReport = <generate the report here>
if(workbookForLatestReport != null){
    bos = new ByteArrayOutputStream();
    workbookForLatestReport.write(bos);
    workbookForLatestBytes = bos.toByteArray();
    workbookForPreviousReport.dispose();
}