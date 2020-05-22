Element table = doc.getElementById(<<Id of table>>);
  if(table != null) {

    int rownum = 0;
        for (Element row : table.select("tr")) {
            HSSFRow exlrow = sheet.createRow(rownum++);
            int cellnum = 0;
                 for (Element tds : row.select("td")) {
                     StringUtils.isNumeric("");
                     HSSFCell cell = exlrow.createCell(cellnum++);
                     cell.setCellValue(tds.text());
                 }

  }