try {
    String path = "C:/Users/Jenny/Desktop/Test.xlsx";
    FileOutputStream out = new FileOutputStream(path);
    wb.write(out);
    out.close();
    wb = new XSSFWorkbook(new FileInputStream(path));
} catch (Exception e) {
    e.printStackTrace();
}