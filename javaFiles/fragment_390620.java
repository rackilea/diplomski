for(int  i=0;i<fileNamesArray.length;i++)
{
    XSSFRow row = worksheet1.createRow(i+1);
    cell1 = row.createCell(0);
    cell1.setCellValue(fileNamesArray[i].toString());

    cell2 = row.createCell(1);
    cell2.setCellValue(fileDatesArray[i].toString());
}