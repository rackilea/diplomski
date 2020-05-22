String[] datez;
String selectQueryz = "SELECT  * FROM table_palembang";
db = new DBHelper(getApplicationContext());
SQLiteDatabase dbz = db.getWritableDatabase();
Cursor cursorz = dbz.rawQuery(selectQueryz, null);
countz = cursorz.getCount();
datez = new String[countz];
for (int k = 0; k < countz; k++) {
    cursorz.moveToNext();
    datez[k] = cursorz.getString(2);
}
xAxis.setValueFormatter(new IAxisValueFormatter() {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        return datez[(int) value];
    }
});