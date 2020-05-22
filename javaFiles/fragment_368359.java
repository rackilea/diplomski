Map<String,String> mapEndoscBarr= new LinkedHashMap<String,String>();
            FileInputStream fis = new FileInputStream(new File(filepath));
            HSSFWorkbook      workBook = new HSSFWorkbook (fis);
            HSSFSheet         sheet    = workBook.getSheetAt (0);

            List<HSSFRow> filteredRows = new ArrayList<HSSFRow>();

            //Filter by pathology from what I am given
            Iterator<Row> rows= sheet.rowIterator(); 
            while (rows.hasNext ()){
            HSSFRow row = (HSSFRow) rows.next ();  
            Iterator<Cell> cells = row.cellIterator (); 
             while (cells.hasNext ()){
                 HSSFCell cell = (HSSFCell) cells.next (); 
                  if (cell.toString().contains("Tamara")) {
                      filteredRows.add(row);
                      break;
                    }
             }
            }