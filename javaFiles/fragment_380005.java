private static final String DATABASE_CREATE_SQL =
        "CREATE TABLE " + DATABASE_TABLE
                + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN + " TEXT NOT NULL, "
                + EMAIL_COLUMN + " TEXT, " // Mind the comma
                + PHONENUMBER_COLUMN + " TEXT NOT NULL, "
                + ADDRESS_COLUMN + " TEXT, " // Mind the comma
                + ZIP_COLUMN + " TEXT NOT NULL, "
                + ARRIVAL_COLUMN + " TEXT NOT NULL, "
                + DEPARTURE_COLUMN + " TEXT, " // Mind the comma
                + ROOM_COLUMN + " TEXT NOT NULL, "
                + NOTES_COLUMN + " TEXT"
                + ");";