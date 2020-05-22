response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition", "attachment; filename=name.xls");
WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
WritableSheet sheet = workbook.createSheet("Sheet1", 0);
sheet.addCell(new Label(0, 0, "Hello World"));
// ...
workbook.write();
workbook.close();