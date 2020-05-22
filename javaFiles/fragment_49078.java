for ( i=0;i<=rowcount;i++)
    {
            Row row = sheet.getRow(i);

        for (j=0;j<cellcount;j++)
        {
            Cell cell = row.getCell(j);
            String cellval = cell.getStringCellValue();
            System.out.print(cellval + "\t\t" );
        }
        System.out.println();
    }