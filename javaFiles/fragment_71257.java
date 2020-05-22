do {
    day = new Days();
    day.setID(cursor.getLong(0));
    day.setStatus(cursor.getInt(1));
    days[i] = day;
    i++;
} while (cursor.moveToNext());