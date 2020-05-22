public class MyDbHelper extends SQLiteOpenHelper {

    //...

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.disableWriteAheadLogging();
        super.onOpen(db);
    }

    //...
}