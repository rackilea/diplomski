HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

    Map<String, Object[]> data = new HashMap<String, Object[]>();
    data.put("1", new Object[] { "Emp No.", "Name", "Salary" });
    data.put("2", new Object[] { 1d, "John", 1500000d });
    data.put("3", new Object[] { 2d, "Sam", 800000d });
    data.put("4", new Object[] { 3d, "Dean", 700000d });

    Set<String> keyset = data.keySet();
    int rownum = 0;
    for (String key : keyset) {
        Row row = sheet.createRow(rownum++);
        Object[] objArr = data.get(key);
        int cellnum = 0;
        for (Object obj : objArr) {
            Cell cell = row.createCell(cellnum++);
            if (obj instanceof Date)
                cell.setCellValue((Date) obj);
            else if (obj instanceof Boolean)
                cell.setCellValue((Boolean) obj);
            else if (obj instanceof String)
                cell.setCellValue((String) obj);
            else if (obj instanceof Double)
                cell.setCellValue((Double) obj);
        }
    }

    try {
        FileOutputStream out = new FileOutputStream(new File("D:\\new.xls"));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");

        /** Opening Excel File From Java **/

        try {
            Desktop.getDesktop().open(new File("D:\\new.xls"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }