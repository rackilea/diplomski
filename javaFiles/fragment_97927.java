if (file11.exists()) {
 String dt = sh1.getRow(0).getCell(1).getStringCellValue();
 if (!dt.equalsIgnoreCase("Date")) {
 Iterator<Row> rowIterator1 = sh1.iterator();
 while (rowIterator1.hasNext()) {
 Row row = rowIterator1.next();                    
 DataFormatter df = new DataFormatter();//instantiate DataFormatter class for reading the cell without changing the cell type
 Cell cl0 = row.getCell(0);
 Cell cl1 = row.getCell(1);
 CellStyle cs1 = cl0.getCellStyle();
 CellStyle cs2 = cl1.getCellStyle();
 String s1 = new String(df.formatCellValue(cl0));//store cell value as string
 String s2 = new String(df.formatCellValue(cl1));//store cell value as string
 cl1.setCellValue(s1);//perform swapping
 cl0.setCellStyle(cs2);
 cl1.setCellStyle(cs1);//perform swapping on formatting
 cl0.setCellValue(s2);//perform swapping  
            }
        }
    } else {
        System.out.println("File does not exist..................");
    }
 }
catch (Exception e) {
        } finally {
           FileOutputStream out = new FileOutputStream(Report_File2);
    workbook11.write(out);
    out.close();
}