// If the row exist in destination, push down all rows by 1 else create a new row
if (newRow != null) {
    worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
} else {
    newRow = worksheet.createRow(destinationRowNum);
}