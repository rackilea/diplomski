File file = File.createTempFile("temp", null);
String fileName = "Temp";
HttpServletResponse response;
CsvConfig config = new CsvConfig(',', '"', '\\');
config.setBreakString(config.getBreakString());
final OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "Shift_JIS");
Csv.save(getApplicationData, out , CSVUtil.getDefaultConfig(),
    new ColumnNameMappingBeanListHandler<WDTO>(WDTO.class)
           .column(label 1, "Date")
           .column(label 2, "Name")
           .column(label 3, "description")
           .column(label 4, "appName")
           .column(label 5, "status"));
DownloadUtils.download(file, fileName, response);