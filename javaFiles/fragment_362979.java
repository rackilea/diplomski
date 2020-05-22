for (int dec = 1; dec <= maxDay; dec++) {
    Row row3 = sheet.getRow(dec + 2);
    Cell cell1 = row3 .createCell(2);
    cal1.set(Calendar.YEAR, 2018);
    cal1.set(Calendar.MONTH, 11);
    cal1.set(Calendar.DAY_OF_MONTH, 1);
    cal1.set(Calendar.DAY_OF_MONTH, dec);
    java.util.Date date1 = cal1.getTime();

    cell1.setCellValue(formatter.format(date1));
}