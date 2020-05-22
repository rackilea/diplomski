public Wfdahelper(Context context) {

    super(context, DATABASE_NAME, null, 1);
    this.mCtx = context;
    createDataBase()
}