Table table = db.getTable("Members");
String dateColumnName = "DateJoined";
Column dateColumn = table.getColumn(dateColumnName);
IndexCursor cursor = CursorBuilder.createCursor(table.getIndex(dateColumnName));

String searchDateAsString = "2014/03/01";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
Date search_date = sdf.parse(searchDateAsString);
cursor.findClosestRowByEntry(search_date);
if (cursor.isAfterLast()) {
    System.out.println(String.format("There are no rows with %s >= %s", dateColumnName, searchDateAsString));
}
else {
    // we want strictly greater than, so skip over the rows that are equal
    while (search_date.equals(cursor.getCurrentRowValue(dateColumn))) {
        if (!cursor.moveToNextRow()) break;
    }
    if (cursor.isAfterLast()) {
        System.out.println(String.format("There are no rows with %s > %s", dateColumnName, searchDateAsString));
    }
}
// now iterate over the remaining rows
while (!cursor.isAfterLast()) {
    System.out.println(sdf.format(cursor.getCurrentRowValue(dateColumn)));
    cursor.moveToNextRow();
}