String longSec = null;
    Double long_sec = null;
    int column_long_sec = 33;
    int c;

    for(c=1; c<=2; c++) {
        row = sheet.getRow(c);
        long_sec = row.getCell(column_long_sec).getNumericCellValue();
        longSec = Double.toString(long_sec);
        Element sid_long_sec = document.createElement("SID_LONG_SEC");
        document.appendChild(sid_long_sec);
        sid_long_sec.appendChild(document.createTextNode(longSec));
    }