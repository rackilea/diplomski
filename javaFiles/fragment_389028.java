public static final String APP_ROLE_CREATE =
            "CREATE TABLE " + APP_ROLE_TABLE_NAME + " (" +
                    APP_ROLE_PRIMARY_KEY + PRIMARY_KEY_TYPE + "," +
                    APP_ROLE_NAME + " TEXT," +
                    APP_ROLE_DISPLAY_NAME +
                    " TEXT);";

public static final String APP_ROLE_INSERT = "INSERT INTO `app_role` (`id`, `name`, `display_name`) VALUES\n" +
                    "(1, 'accueil', 'Accueil'),\n" +
                    "(2, 'responsable_cercle', 'responsable de cercle');\n";

@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                APP_ROLE_CREATE
        );
        db.execSQL(
                APP_ROLE_INSERT
        );
    }