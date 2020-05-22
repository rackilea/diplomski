private static final int VERSION = 2; // increased from 1

private DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, VERSION);
}

...

@Override
public void onUpdgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    switch (oldVersion) {
        case 1:
            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN INVENTORY TEXT");
        // intentionally fall through to other cases
    }
}