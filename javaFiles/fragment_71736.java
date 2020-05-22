rownum = 2;
while(resultSet.next()) 
{
    row1.createCell(rownum).setCellValue(resultSet.getString(1));
    row2.createCell(rownum).setCellValue(resultSet.getString(2));
    row3.createCell(rownum).setCellValue(resultSet.getString(3));
    rownum++;
}