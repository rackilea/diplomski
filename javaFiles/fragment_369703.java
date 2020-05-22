public static final String CUSTOM_REMINDER_TABLE = "CREATE TABLE " + Contract.customReminder.TABLE_NAME + "("
    + Contract.customReminder.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    + Contract.customReminder.TITLE + " TEXT,"
    + Contract.customReminder.DESCRIPTION + " TEXT,"
    + Contract.customReminder.DATE_TIME + " TEXT,"
    + ");";