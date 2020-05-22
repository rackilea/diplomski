HSSFWorkbook wb = new HSSFWorkbook();
// Populate

ByteArrayOutputStream baos = new ByteArrayOutputStream();
wb.write(baos);
byte[] data = baos.toByteArray();