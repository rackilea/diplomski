if (cursor != null) && (cursor.moveToFirst)
{
    txtMyTextView.setText(String,format("%s %s %s",
    cursor.getString(cur.getColumnIndex("title")),
    cursor.getString(cur.getColumnIndex("firstName")),
    cursor.getString(cur.getColumnIndex("lastName"))))
}