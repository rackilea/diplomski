public class DataBaseHelper {
private static final String DB_NAME = "DB_BusData";
public static final String TABLE_NAME = "Tbl_Driver";

private Context context;
private String path;

private SQLiteDatabase database;
private boolean isInitializing = false;

public DataBaseHelper(Context context) {
    this.context = context;
    this.path = context.getDatabasePath(DB_NAME).getAbsolutePath();

    if (TextUtils.isEmpty(this.path)) {
        throw new IllegalArgumentException("database can't be null");
    }
}

public SQLiteDatabase getReadableDatabase() {
    synchronized (this) {
        checkAndCopyDatabase();
        return getDatabaseLocked(false);
    }
}

/**
 * Attention：just support readable database until now
 *
 * @return
 */
public SQLiteDatabase getWriteableDatabase() {
    synchronized (this) {
        checkAndCopyDatabase();
        return getDatabaseLocked(true);
    }
}

private void checkAndCopyDatabase() {
    File file = new File(this.path);
    if (file.exists() && file.length() > 0) {
        Log.d("TAG", "db already exist");
    } else {
        try {
            InputStream is = context.getAssets().open(DB_NAME);
            copyStreamToFile(is, new File(this.path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

private static final void copyStreamToFile(InputStream inputStream, File file) {
    ensureDir(file);

    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(file);
        byte[] buffer = new byte[2048];
        int read = 0;
        while ((read = inputStream.read(buffer)) > 0) {
            fos.write(buffer, 0, read);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        quietClose(inputStream);
        quietClose(fos);
    }
}

private static final void ensureDir(File file) {
    if (file != null && (file = file.getParentFile()) != null && !file.exists()) {
        file.mkdirs();
    }
}

private static final void quietClose(final Closeable closeable) {
    if (closeable != null) {
        try {
            closeable.close();
        } catch (final IOException e) {
        }
    }
}

private SQLiteDatabase getDatabaseLocked(boolean writeable) {
    if (this.database != null) {
        if (!this.database.isOpen()) {
            database = null;
        } else if (!writeable || !database.isReadOnly()) {
            return database;
        }
    }

    if (isInitializing) {
        throw new IllegalArgumentException("getDatabase called recursively");
    }

    SQLiteDatabase db = this.database;

    try {
        isInitializing = true;
        if (db != null && writeable && db.isReadOnly()) {
            if (db.isOpen()) {
                db.close();
            }
            db = null;
        }
        try {
            db = SQLiteDatabase.openDatabase(this.path, null,
                    writeable ? SQLiteDatabase.OPEN_READWRITE : SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        this.database = db;
        return db;
    } finally {
        isInitializing = false;
        if (db != null && db != database) {
            db.close();
        }
    }
}

public static class Driver implements BaseColumns {
    long id;
    String code;
    String name;

    static final String CODE_CLOMN_NAME = "Driver_Code";
    static final String NAME_CLOMN_Name = "Driver_Name";

    @Override
    public String toString() {
        return name;
    }
}

public List<Driver> queryAllDriver() {
    List<Driver> drivers = null;

    SQLiteDatabase db = getReadableDatabase();
    if (db != null) {
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            if(cursor != null && cursor.moveToFirst()) {
                do {
                    final long id = cursor.getLong(cursor.getColumnIndex(Driver._ID));
                    final String code = cursor.getString(cursor.getColumnIndex(Driver.CODE_CLOMN_NAME));
                    final String name = cursor.getString(cursor.getColumnIndex(Driver.NAME_CLOMN_Name));

                    Driver driver = new Driver();
                    driver.id = id;
                    driver.code = code;
                    driver.name = name;

                    if(drivers == null)
                        drivers = new ArrayList<DataBaseHelper.Driver>();

                    drivers.add(driver);
                } while(cursor.moveToNext());
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();
        }

        db.close();
    }

    return drivers;
}