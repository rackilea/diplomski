package ...;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataHandlerDB {

  public static void persistAll(Context ctx, List<Module> moduleList) {

      DatabaseHelper helper = new DatabaseHelper(ctx);

      SQLiteDatabase db = helper.getWritableDatabase();

      ContentValues values = new ContentValues();
      for (Module m : moduleList) {

          values.put("_id", m.get_id());
          values.put("name", m.getModule());

          db.insert("module", null, values);
      }
      db.close();
  }

  public static List<Module> findAll(Context ctx) {

      List<Module> result = new ArrayList<Module>();
      DatabaseHelper helper = new DatabaseHelper(ctx);
      SQLiteDatabase db = helper.getReadableDatabase();

      Cursor c = db.query(ModuleDB.TABLE_NAME, new String[] { ModuleDB.ID,
            ModuleDB.MODULE}, null, null, null, null, null);

      while (c.moveToNext()) {
          Module m = new Module(c.getInt(0), c.getString(1));
          result.add(m);
      }
      c.close();
      db.close();

      return result;
  }

  // Update Database entry
  public static void update(Context ctx, Module m) {

      DatabaseHelper helper = new DatabaseHelper(ctx);
      SQLiteDatabase db = helper.getWritableDatabase();
      ContentValues values = new ContentValues();

      values.put("_id", m.get_id());
      values.put("name", m.getModule());

      db.update("module", values, null, null);
      db.close();
  }

  public static void delete(Context ctx, Module m) {

      DatabaseHelper helper = new DatabaseHelper(ctx);
      SQLiteDatabase db = helper.getWritableDatabase();
      ContentValues values = new ContentValues();

      values.put("_id", m.get_id());
      values.put("name", m.getModule());

      db.delete("module","_id = m.get_id()", null);
      db.close();
  }

  public static void createDB(Context ctx) {
      DatabaseHelper helper = new DatabaseHelper(ctx);
      SQLiteDatabase db = helper.getWritableDatabase();
      db.close();
  }
}