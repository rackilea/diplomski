JSONObject jo = new JSONObject();
        JSONArray dataCollection = new JSONArray();
        JSONObject data = null;
        try {
            String tempCampaignFilesPath = getSessionData("userPath") + System.getProperty("file.separator") + "tempCampaignFiles";
            File someFile = new File(tempCampaignFilesPath, fileName);

            /* read from this file */

            FileInputStream fileInputStream = new FileInputStream(someFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheet(sheetName);

            int rowNum = sheet.getLastRowNum() + 1;
            int colNum = sheet.getRow(0).getLastCellNum();
            Row row = null;
            Cell cell = null;

            /* first row data for column names and index */

            Map<String, Integer> colMapByName = new HashMap<String, Integer>();
            if (sheet.getRow(0).cellIterator().hasNext()) {
                for (int j = 0; j < colNum; j++) {
                    colMapByName.put(cellToString(sheet.getRow(0).getCell(j)), j);
                }
            }
            System.out.println(colMapByName);//shows the indexes of columns populated by traversing first row
            /* first row data */

            for (int i = 1; i < rowNum; i++) {
                row = sheet.getRow(i);
                data = new JSONObject();
                //colMap consists the columnnames and alias name for it
                for (Entry<String, String> colData : colMap.entrySet()) {
                    cell = row.getCell(colMapByName.get(colData.getValue()));//gives the index of column from  colMapByName Map by passing column name
                    data.put(colData.getKey(), cellToString(cell));//now the data passed to the alias for the column tobe used in application
                }
                dataCollection.put(data);
            }
            fileInputStream.close();
            someFile.delete();
            jo.put("tableData", dataCollection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jo;