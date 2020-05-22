...
if (pieCase.getActualAmountReturned() == null) {
 userRow.createCell(2).setBlank();
} else {
 userRow.createCell(2).setCellValue(pieCase.getActualAmountReturned());
}
...