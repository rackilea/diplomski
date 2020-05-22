private static final int DBVERSION=1; 


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DBVERSION);
    }