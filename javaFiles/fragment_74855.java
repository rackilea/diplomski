try
    {
        FileInputStream file = new FileInputStreaHashMap<K, V>ile(path));
        HashMap<Integer, Data> mp= new HashMap<Integer, Data>();
        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

         System.out.println("");

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                int i=0;
                int j=0;
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                            i=Integer.parseInt(cell.getNumericCellValue());
                            Data d= new Data();
                            d.setId(cell.getNumericCellvalue());


                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        if( j==0){
                        Data data= mp.get(i);
                        data.setName(cell.getStringCellValue());
                        mp.put(i, data);
                        j=j+1;
                        }
                        else
                        {
                            Data data= mp.get(i);
                            data.setLastName(cell.getStringCellValue());
                            mp.put(i, data);
                            j=0;
                        }
                        break;
                }
            }


            System.out.println("");
        }
        List<Data> dataList=  new ArrayList<Data>();
        for (Data d : mp.values()) {
           dataList.add(d);

        }
        file.close();
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }