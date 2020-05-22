final String originalExcel = "D:\\work\\excel\\original.xls";
 String pathname = "D:\\work\\excel\\generated\\custom1.xls";
 File original = new File(originalExcel);
 File file = new File(pathname);
 FileUtils.copyFile(original, file);//I copied from my template before before changing it
 FileInputStream stream = new FileInputStream(file);
 final HSSFWorkbook wb = new HSSFWorkbook(stream);
 final HSSFSheet sheet = wb.getSheetAt(1); // so, here I can change my custom excel file.