Cursor cursor = getWritableDatabase().rawQuery("select (" + gasLog.getOdometer() + " - y.odometer) / " + gasLog.getGallons() + " as mpg from gasLog x, gasLog y where y.odometer = (select max(z.odometer) from gasLog z where z.odometer < " + gasLog.getOdometer() + ")", null);
try {
    cursor.moveToFirst();
    int key = 1;
    while (true) {
        mpg = cursor.getString(0);
        values.put(KEY_MPG, mpg);
        db.update(TABLE_GASLOG, values, "_id=?", new String[]{String.valueOf(key)});
        if (cursor.isLast())
            break;
        cursor.moveToNext();
        key++;
    }
} finally {
    cursor.close();
}
db.close();