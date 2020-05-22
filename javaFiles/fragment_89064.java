OutputStream output = new FileOutputStream(file);
workbook.write(output);
workbook.dispose();
output.flush();
output.close();

InputStream input = new FileInputStream(file);
Blob blob = dao.saveInputStreamToBlob(input);