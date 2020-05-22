for (int notdec = 1; notdec <= 365; notdec++) {

    Row row3 = sheet.getRow(maxDay +3 + notdec);  // THIS

    Cell cell1 = row3.createCell(2);      // THIS

    cal1.set(Calendar.YEAR, 2019);       // THIS
    cal1.set(Calendar.DAY_OF_YEAR, notdec);   // THIS
    java.util.Date date1 = cal1.getTime();

    cell1.setCellValue(formatter.format(date1));
}