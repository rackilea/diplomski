public List<Event> printMonths(String eventId, String date) {
    List<Event> events = new ArrayList<>();
    String selectQuery = "SELECT eventName, date FROM events WHERE eventId = ? AND date LIKE ?";
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, new String[]{eventId, "%" + date});
    if (cursor.moveToFirst()) {
    do {
            Event event = new Event();
            event.setName(cursor.getString(0));
            event.setDate(cursor.getString(1));
            events.add(event);
       } while (cursor.moveToNext());
   }
    db.close();
    return events;
}