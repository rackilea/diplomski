"CREATE TABLE " + Food_TABLE +"(" +
    EX_RowID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
    EX_Cattype + " TEXT NOT NULL, " +
    EX_Date + " INTEGER NOT NULL," +
    EX_Price + " INTEGER NOT NULL," +
    EX_Type + " TEXT NOT NULL UNIQUE );"

private static String dateOnly(java.util.Date d) {
    Calendar cal = Calendar.getInstance(); // locale-specific
    cal.setTime(d);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return Long.toString(cal.getTimeInMillis());
}

public Cursor CstmRpot(java.util.Date fd, java.util.Date td) {
    // TODO Auto-generated method stub
    String[] columns = new String[]{EX_RowID,EX_Cattype, EX_Date, EX_Price, EX_Type };
    Cursor c= ourdatabase.query(Food_TABLE, columns, EX_Date + " > " + dateOnly (fd) + " AND " + EX_Date + " < " + dateOnly(td), null, null, null, null);
    if (c != null) {
        c.moveToFirst();
    }
    return c;
}