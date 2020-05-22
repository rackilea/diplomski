public boolean openExcelFile(String fileName) {
  try {
   File file = new File(fileName);
   Desktop.getDesktop().open(file);
  } catch(Exception ex) {
   ex.printStackTrace();
   return false;
  }
  return true;
 }