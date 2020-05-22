import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "MyDBName.db";
   public static final String CONTACTS_TABLE_NAME = "barcode";
   public static final String CONTACTS_COLUMN_ID = "id";
   public static final String CONTACTS_COLUMN_TEXT1 = "field1";
   public static final String CONTACTS_COLUMN_TEXT2 = "field2";

   private HashMap hp;

   public DBHelper(Context context) {
      super(context, DATABASE_NAME , null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      // TODO Auto-generated method stub
      db.execSQL(
         "create table barcode" +
         "(id integer primary key, field1 text, field2 text)"
      );
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // TODO Auto-generated method stub
      db.execSQL("DROP TABLE IF EXISTS barcode");
      onCreate(db);
   }

   public boolean insertData (String text1, String text2) {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("field1", text1);
      contentValues.put("field2", text2);
      db.insert("barcode", null, contentValues);
      return true;
   }

   public Cursor getData(int id) {
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from barcode where id="+id+"", null );
      return res;
   }



   public boolean updateBarcode (Integer id, String text1, String text2) {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("field1", text1);
      contentValues.put("field2", text2);
      db.update("barcode", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
      return true;
   }