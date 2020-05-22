public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TABLE_USERS = "users";
    public static final String KEY_ID = BaseColumns._ID;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_SAT_READING = "reading";
    public static final String KEY_SAT_MATH = "satmath";
    public static final String KEY_ACT_READING = "actreading";
    public static final String KEY_ACT_MATH = "actmath";

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String users_crt_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_USERNAME + " TEXT UNIQUE," +
                KEY_PASSWORD + " TEXT," +
                KEY_SAT_READING + " TEXT," +
                KEY_SAT_MATH + " TEXT," +
                KEY_ACT_READING + " TEXT," +
                KEY_ACT_MATH + " TEXT" +
                ")";
        db.execSQL(users_crt_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertNewUser(String name, String password) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_USERNAME,name);
        cv.put(KEY_PASSWORD,password);
        return db.insert(TABLE_USERS,null,cv);
    }

    public User checkUser(String name, String password) {
        User rv = null;
        Cursor csr = db.query(
                TABLE_USERS,
                null,
                KEY_USERNAME + "=? AND " + KEY_PASSWORD + "=?",
                new String[]{name,password},
                null,null,null
        );
        if (csr.moveToFirst()) {
            rv = new User();
            rv.setUserId(csr.getLong(csr.getColumnIndex(KEY_ID)));
            rv.setUserName(name);
            rv.setUserPassword("");
            rv.setUserSatReading(csr.getString(csr.getColumnIndex(KEY_SAT_READING)));
            rv.setUserSatMath(csr.getString(csr.getColumnIndex(KEY_SAT_MATH)));
            rv.setUserActReading(csr.getString(csr.getColumnIndex(KEY_ACT_READING)));
            rv.setUserActMath(csr.getString(csr.getColumnIndex(KEY_ACT_MATH)));
        }
        csr.close();
        return rv;
    }

    public class User {
        long userId;
        String userName;
        String userPassword;
        String userSatReading;
        String userSatMath;
        String userActReading;
        String userActMath;

        public User() {
        }

        public User(String name, String password) {
            this(-1L, name, password, null, null, null, null);
        }

        public User(long id, String name, String password, String satReading, String satMath, String actReading, String actmath) {
            this.userId = id;
            this.userName = name;
            this.userPassword = password;
            this.userSatReading = satReading;
            this.userSatMath = satMath;
            this.userActReading = actReading;
            this.userActMath = actmath;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserSatReading() {
            return userSatReading;
        }

        public void setUserSatReading(String userSatReading) {
            this.userSatReading = userSatReading;
        }

        public String getUserSatMath() {
            return userSatMath;
        }

        public void setUserSatMath(String userSatMath) {
            this.userSatMath = userSatMath;
        }

        public String getUserActReading() {
            return userActReading;
        }

        public void setUserActReading(String userActReading) {
            this.userActReading = userActReading;
        }

        public String getUserActMath() {
            return userActMath;
        }

        public void setUserActMath(String userActMath) {
            this.userActMath = userActMath;
        }
    }
}