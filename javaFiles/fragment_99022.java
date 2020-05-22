public static final String SQL_CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY, " +
            COLUMN_TASK_NAME + " TEXT UNIQUE NOT NULL, " +
            COLUMN_CATEGORY_ID + " INTEGER , " + //<<<<<<<<<<
            COLUMN_SKILL_ID + " INTEGER, " + //<<<<<<<<<<
            COLUMN_TASK_PD + ", " +
            COLUMN_TASK_DATE + ", " +
            COLUMN_TASK_PERIOD + ", " +
            COLUMN_TASK_FREQUENCY + ", " +
            COLUMN_TASK_ONBY + ", " +
            COLUMN_TASK_COMPLETION + ")";