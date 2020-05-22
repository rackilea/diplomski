while (rows.hasNext()) {
            XSSFRow row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();

            List data = new ArrayList();       
   while (cells.hasNext()) {
                XSSFCell cell = (XSSFCell) cells.next();
                String value=" ";
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_NUMERIC:
                      value =                BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                        data.add(value);
                        break;
                    case Cell.CELL_TYPE_STRING:
                        value=cell.getStringCellValue();
                        data.add(value);
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        value = " ".toString();
                        data.add(value);
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = Boolean.valueOf(cell.getBooleanCellValue()).toString();
                        data.add(value);
                        break;
                }

                //sheetData.add(data);

            }
       sheetData.add(data);
      fis.close();
      }