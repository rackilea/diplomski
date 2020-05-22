public class ChatsProvider extends ContentProvider {


    public static final String AUTHORITY = "mynet.app.data.cprov.Provider;

    private static final String CHATS_TABLE = "CHATS";
    private static final String CONTACTS_TABLE = "CONTACTS;
    private static final String UPDATES_TABLE = "UPDATES";
    private static final String UPLOADED_CONTACTS_TABLE = "UPLOADED_CONTACTS";
    private static final String PRODUCTS_TABLE = "PRODUCTS";
    private static final String ROOMS_TABLE = "ROOMS";


    private static final String MOCK_TABLE = "MOCK";



    public static final String MOCK_COLUMN = "MOCK_COLUMN";




    public static final Uri CONTENT_URI_CHATS =
            Uri.parse("content://" + AUTHORITY + "/" + CHATS_TABLE);
    public static final Uri CONTENT_URI_CONTACTS =
            Uri.parse("content://" + AUTHORITY + "/" + CONTACTS_TABLE);
    public static final Uri CONTENT_URI_UPDATES =
            Uri.parse("content://" + AUTHORITY + "/" + UPDATES_TABLE);
    public static final Uri CONTENT_URI_UPLOADED_CONTACTS =
            Uri.parse("content://" + AUTHORITY + "/" + UPLOADED_CONTACTS_TABLE);
    public static final Uri CONTENT_URI_PRODUCTS =
            Uri.parse("content://" + AUTHORITY + "/" + PRODUCTS_TABLE);
    public static final Uri CONTENT_URI_ROOMS =
            Uri.parse("content://" + AUTHORITY + "/" + ROOMS_TABLE);

    public static final Uri CONTENT_URI_MOCK =
            Uri.parse("content://" + AUTHORITY + "/" + MOCK_TABLE);


    public static final int CHATS = 1;
    public static final int CHATS_ID = 100;


    public static final int CONTACTS = 101;
    public static final int CONTACTS_ID = 200;

    public static final int UPDATES = 201;
    public static final int UPDATES_ID = 300;

    public static final int UPLOADED_CONTACTS = 301;
    public static final int UPLOADED_CONTACTS_ID = 400;

    public static final int PRODUCTS = 401;
    public static final int PRODUCTS_ID = 500;

    public static final int ROOMS = 501;
    public static final int ROOMS_ID = 600;


    public static final int MOCK = 601;
    public static final int MOCK_ID = 700;













    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
/**
 * My SQLiteOpenHelper
 */
    public static DatabaseUtils databaseUtils;

    static {
        uriMatcher.addURI(AUTHORITY, CHATS_TABLE, CHATS);
        uriMatcher.addURI(AUTHORITY, CHATS_TABLE + "/#",
                CHATS_ID);

        uriMatcher.addURI(AUTHORITY, CONTACTS_TABLE, CONTACTS);
        uriMatcher.addURI(AUTHORITY, CONTACTS_TABLE + "/#",
                CONTACTS_ID);

        uriMatcher.addURI(AUTHORITY, UPDATES_TABLE, UPDATES);
        uriMatcher.addURI(AUTHORITY, UPDATES_TABLE + "/#",
                UPDATES_ID);

        uriMatcher.addURI(AUTHORITY, UPLOADED_CONTACTS_TABLE, UPLOADED_CONTACTS);
        uriMatcher.addURI(AUTHORITY, UPLOADED_CONTACTS_TABLE + "/#",
                UPLOADED_CONTACTS_ID);

        uriMatcher.addURI(AUTHORITY, PRODUCTS_TABLE, PRODUCTS);
        uriMatcher.addURI(AUTHORITY, PRODUCTS_TABLE + "/#",
                PRODUCTS_ID);

        uriMatcher.addURI(AUTHORITY, ROOMS_TABLE, ROOMS);
        uriMatcher.addURI(AUTHORITY, ROOMS_TABLE + "/#",
                ROOMS_ID);


        uriMatcher.addURI(AUTHORITY, MOCK_TABLE, MOCK);
        uriMatcher.addURI(AUTHORITY, MOCK_TABLE + "/#",
                MOCK_ID);

    }





    public ChatsProvider() {
    }


    @Override
    public synchronized boolean onCreate() {
        Utils.logErrorMessage("ContentProvider-"+this+" is up and running!", getClass());
        if(databaseUtils == null){
            databaseUtils = DatabaseUtils.getInstance(this.getContext());
        }
        return false;
    }



    @Override
    public synchronized Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        int uriType = uriMatcher.match(uri);
        String table = null;
        switch (uriType) {
            case CHATS:
                table = CHATS_TABLE;
                break;
            case CONTACTS:
                table = CONTACTS_TABLE;
                break;
            case UPDATES:
                table = UPDATES_TABLE;
                break;
            case UPLOADED_CONTACTS:
                table = UPLOADED_CONTACTS_TABLE;
                break;
            case PRODUCTS:
                table = PRODUCTS_TABLE;
                break;
            case ROOMS:
                table = ROOMS_TABLE;
                break;
            case MOCK:
                table = MOCK_TABLE;
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        if(table.equals(MOCK_TABLE)){
            String[] value = { DatabaseUtils.initializationRunning + "" };
            String[] mockProjection = new String[]{"MOCK_COLUMN"};
            MatrixCursor c = new MatrixCursor(mockProjection);
            c.addRow(value);
            return c;
        }
        try {
            SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
            queryBuilder.setTables(table);

            Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            cursor.setNotificationUri(AppController.contentResolver,
                    uri);
            return cursor;
        }
        catch (Exception e){
            return null;
        }

    }

}