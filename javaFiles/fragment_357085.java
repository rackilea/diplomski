Cursor cursor = cr.query(Uri.parse("content://calendar/events"), new String[]{ "calendar_id", "title", "description", "dtstart", "dtend", "eventLocation" }, null, null, null);         
//Cursor cursor = cr.query(Uri.parse("content://calendar/calendars"), new String[]{ "_id", "name" }, null, null, null);
String add = null;
cursor.moveToFirst();
String[] CalNames = new String[cursor.getCount()];
int[] CalIds = new int[cursor.getCount()];
for (int i = 0; i < CalNames.length; i++) {
    CalIds[i] = cursor.getInt(0);
    CalNames[i] = "Event"+cursor.getInt(0)+": \nTitle: "+ cursor.getString(1)+"\nDescription: "+cursor.getString(2)+"\nStart Date: "+new Date(cursor.getLong(3))+"\nEnd Date : "+new Date(cursor.getLong(4))+"\nLocation : "+cursor.getString(5);
    if(add == null)
        add = CalNames[i];
    else{
        add += CalNames[i];
    }           
    ((TextView)findViewById(R.id.calendars)).setText(add);

    cursor.moveToNext();
}
cursor.close();