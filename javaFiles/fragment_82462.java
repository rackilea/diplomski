public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("zip.xls"));

        //Get the workbook instance for XLS file 
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        //Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                //Check the cell type after eveluating formulae
                //If it is formula cell, it will be evaluated otherwise no change will happen
                switch (evaluator.evaluateInCell(cell).getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        //System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    }