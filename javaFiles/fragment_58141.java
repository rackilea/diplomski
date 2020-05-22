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