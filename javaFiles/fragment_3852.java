@Inject
public SQLiteHandler(@ForApplication Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.context = context;
}

@Inject
public ServerHandler() {
}