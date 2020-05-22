import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class ShipAdapter extends MyDbAdapter {
    public static final String TAG = "ShipAdapter";
    public static final String TABLE = "ships";

    public static final String C_ID = BaseColumns._ID;
    public static final String C_NAME = "name";
    public static final String C_CRUISE_LINE = "cruise_line";

    public ShipAdapter(Context context) {
        this.context = context;
    }

    public long createShip(String name, long cruise_line_id) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(C_NAME, name);
        initialValues.put(C_CRUISE_LINE, cruise_line_id);

        return db.insert(TABLE, null, initialValues);
    }

    public long createShip(long id, String name, long cruise_line_id) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(C_ID, id);
        initialValues.put(C_NAME, name);
        initialValues.put(C_CRUISE_LINE, cruise_line_id);

        return db.insert(TABLE, null, initialValues);
    }

    public long createShip(ShipModel ship) {
        return createShip(ship.getName(), ship.getCruiseLineId());
    }

    public long insertOrIgnoreShip(long id, String name, long cruise_line_id) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(C_ID, id);
        initialValues.put(C_NAME, name);
        initialValues.put(C_CRUISE_LINE, cruise_line_id);

        return db.insertWithOnConflict(TABLE, null, initialValues, SQLiteDatabase.CONFLICT_IGNORE);
    }

    public long insertOrIgnoreShip(ShipModel ship) {
        return insertOrIgnoreShip(ship.getId(), ship.getName(), ship.getCruiseLineId());
    }

    public List<ShipModel> getAllShips() {
        List<ShipModel> ships = new ArrayList<ShipModel>();
        Cursor cursor = getAllShipsCursor();

        if (cursor.getCount() > 0) {
            while(!cursor.isAfterLast()) {
                ships.add(cursorToShip(cursor));
                cursor.moveToNext();
            }
        }

        return ships;
    }

    public Cursor getAllShipsCursor() {
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public ShipModel getShip(long id) {
        Cursor cursor = getShipCursor(id);

        if (cursor.getCount() > 0) {
            return cursorToShip(cursor);
        }

        return null;
    }

    public Cursor getShipCursor(long id) {
        Cursor cursor = db.query(TABLE, null, C_ID + " = ?", new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public ShipModel getShip(String name) {
        Cursor cursor = getShipCursor(name);

        if (cursor.getCount() > 0) {
            return cursorToShip(cursor);
        }

        return null;
    }

    public Cursor getShipCursor(String name) {
        Cursor cursor = db.query(TABLE, null, C_NAME + " = ?", new String[] { name }, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public List<ShipModel> getShipsByCruiseLine(long cruise_line_id) {
        List<ShipModel> ships = new ArrayList<ShipModel>();
        Cursor cursor = getShipsCursorByCruiseLine(cruise_line_id);

        if (cursor.getCount() > 0) {
            while (!cursor.isAfterLast()) {
                ships.add(cursorToShip(cursor));
                cursor.moveToNext();
            }
        }

        return ships;
    }

    public Cursor getShipsCursorByCruiseLine(long cruise_line_id) {
        Cursor cursor = db.query(TABLE, null, C_CRUISE_LINE + " = ?", new String[] { String.valueOf(cruise_line_id) }, null, null, null, null);

        if (cursor.getCount() > 0) { 
            cursor.moveToFirst();
        }

        return cursor;
    }

    public boolean updateShip(long id, String name, long cruise_line_id) {
        ContentValues args = new ContentValues();
        args.put(C_NAME, name);
        args.put(C_CRUISE_LINE, cruise_line_id);

        return db.update(TABLE, args, C_ID + " = ?", new String[] { String.valueOf(id) }) > 0;
    }

    public boolean updateShip(ShipModel ship) {
        return updateShip(ship.getId(), ship.getName(), ship.getCruiseLineId());
    }

    public boolean deleteShip(long id) {
        return db.delete(TABLE, C_ID + " = ?", new String[] { String.valueOf(id) }) > 0;
    }

    public boolean deleteShip(String name) {
        return db.delete(TABLE, C_NAME + " = ?", new String[] { name }) > 0;
    }

    public boolean deleteShip(ShipModel ship) {
        return deleteShip(ship.getName());
    }

    public boolean deleteAll() {
        return db.delete(TABLE, null, null) > 0;
    }

    private ShipModel cursorToShip(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(C_ID));
        String name = cursor.getString(cursor.getColumnIndex(C_NAME));
        long cruise_line_id = cursor.getLong(cursor.getColumnIndex(C_CRUISE_LINE));

        return new ShipModel(id, name, cruise_line_id);
    }
}