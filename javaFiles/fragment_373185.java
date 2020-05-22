while (rows.hasNext()) {
            XSSFRow row = (XSSFRow) rows.next();
            if(rowCount==3){
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                XSSFCell cell = (XSSFCell) cells.next();
                    System.out.print(cell.getStringCellValue()+"\t");
                }
            }
            System.out.println();
            rowCount++;
        }