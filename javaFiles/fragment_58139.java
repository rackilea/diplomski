int maxNumOfCells = sheet.getRow(0).getLastCellNum(); // The the maximum number of columns
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                for( int cellCounter = 0
                        ; cellCounter < maxNumOfCells
                        ; cellCounter ++){ // Loop through cells

                    HSSFCell cell;

                    if( row.getCell(cellCounter ) == null ){
                        cell = row.createCell(cellCounter);
                    } else {
                        cell = row.getCell(cellCounter);
                    }

                    data.add(cell);

                }

                sheetData.add(data);