public void readExcel(String filePath)
    { 
        try
         {
             List sheetData = new ArrayList();
            FileInputStream file=new FileInputStream(new File(filePath));

            //Getting the instance for XLS file 
             HSSFWorkbook workbook=new HSSFWorkbook(file);

             //Get First sheet from the workbook
            HSSFSheet sheet=workbook.getSheetAt(0);

            //Iterate start from the first sheet of the uploaded excel file
              Iterator<Row> rowIterator = sheet.iterator();

              while (rowIterator.hasNext()) {
                   Row row = (Row) rowIterator.next();

                   // CHANGE 
                   Company company = new Company();
                   company.setName(getCellValue(row.getCell((short)1)));

                   // HERE YOU CAN SAVE COMPANY 
                   dao.saveOrUpdateCompany(company);

                   // OR ADD COMPANY TO LIST 
                   // List<Company> companies = new ArrayList<Company>();
                   // Declare just one list for entire class not per row
                   // In this case you call custom made DAO method which batch save
                   // all company entities in list but you call this custom method
                   // at the end of excel processing (your original dao code position).
                   // Try it without list first  
                   list.add(company);    


              }



              System.out.println("Seet data size-"+sheetData.size());
              file.close();
            FileOutputStream out=
                    new FileOutputStream(new File(filePath));

              workbook.write(out);
              out.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }