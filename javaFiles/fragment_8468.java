InputStream in = new FileInputStream (path);
Workbook sampleWorkbook;
try{
  sampleWorkbook = new HSSFWorkbook (in);//or XSSFWorkbook depending on whether you use xls or xlsx
} finally
{
  in.close ();
}

//Add some rows into the workbook

OutputStream out = new FileOutputStream (path);
try{
  sampleWorkbook.write (out);
} finally
{
  out.close ();
}