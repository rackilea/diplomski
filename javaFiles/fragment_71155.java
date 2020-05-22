private static MySQLiteOpenHelper self;

private MySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
}

private MySQLiteOpenHelper(Context context) {
    this(context, "myDb", null, 1);
}

public static MySQLiteOpenHelper sharedHelper(Context context) {
    if (self == null)
        self = new MySQLiteOpenHelper(context);
    return self;
}