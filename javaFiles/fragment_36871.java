...
        XSSFRow rowx = sheet.createRow(i + 1);
        XSSFCell cellx = rowx.createCell(1);
        cellx.setCellValue("Total");
        for (int j = columnStart+1 ; j <= areaColumn; j++) 
        {
            cellx = rowx.createCell(j);
            cellx.setCellFormula("SUBTOTAL(109," + wantedDisplayName + "[" + multi[0][j-1] + "])");
        }
...