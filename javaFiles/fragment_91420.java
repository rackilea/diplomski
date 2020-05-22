int timeColumn = mCursor.getColumnIndex(TIMECOLUMN);
String dbDateText = mCursor.getString(timeColumn);
Date dbDate = format.parse(dbDateText);

if (currentDate.compareTo(dbDate) > 0) {
}