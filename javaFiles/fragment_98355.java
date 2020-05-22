Iterator<Row> rowIterator = sheet.iterator();
        boolean isHeader = true;
        HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        HashMap<Integer, String> headers = new HashMap<Integer, String>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
            int rowNum = 1;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    if (isHeader) {
                        data.put(String.valueOf(cell.getNumericCellValue()), new ArrayList<String>());
                        headers.put(rowNum, String.valueOf(cell.getNumericCellValue()));
                    } else {
                        ArrayList<String> tmp = data.get(headers.get(rowNum));
                        tmp.add(String.valueOf(cell.getNumericCellValue()));
                        data.put(headers.get(rowNum), tmp);
                    }
                    System.out.print(cell.getNumericCellValue() + ";");
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (isHeader) {
                        data.put(cell.getStringCellValue(), new ArrayList<String>());
                        headers.put(rowNum, cell.getStringCellValue());
                    } else {
                        ArrayList<String> tmp = data.get(headers.get(rowNum));
                        tmp.add(cell.getStringCellValue());
                        data.put(headers.get(rowNum), tmp);
                    }
                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    if (isHeader) {
                        data.put("", new ArrayList<String>());
                        headers.put(rowNum, "");
                    } else {
                        ArrayList<String> tmp = data.get(headers.get(rowNum));
                        tmp.add("");
                        data.put(headers.get(rowNum), tmp);
                    }
                }
                rowNum++;
            }
            if (isHeader) {
                isHeader = false;
            }
        }
        file.close();