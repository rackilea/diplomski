public class Notes {

    public static final String TABLE_NAME = "notes";
    public static final String NOTE_COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_NOTE = "note";
    public static final String NOTE_COLUMN_USERMAP = "usermap";

    public static final String CREATE_TABLE_NOTE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME  + "(" +
            NOTE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NOTE + " TEXT, " +
            NOTE_COLUMN_USERMAP + " INTEGER " +
            "REFERENCES " + DBHelper.TABLE_USER_NAME + "(" + DBHelper.USER_COLUMN_ID + ") " +
            "ON DELETE CASCADE ON UPDATE CASCADE" +
            ")";

    public Notes(int id, String note, long usermap) {
        this.id = id;
        this.note = note;
        this.usermap = usermap;
    }

    public Notes() {}

    private int id;
    private String note;
    private long usermap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getUsermap() {
        return usermap;
    }

    public void setUsermap(long usermap) {
        this.usermap = usermap;
    }
}