public class Example
{

String sp,st;
SQLiteDatabase database, database2;
void func()
{
 new AlertDialog.Builder(view.getContext())
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle("Confirm")
        .setMessage("Are you sure?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          String st = editTextSt.getText().toString();
    String sp = editTextSp.getText().toString();
    database2 = new SQLiteDbHelper(this);
    database = database2.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(SQLiteDbHelper.COLUMN_NAME_SP, sp);
    values.put(SQLiteDbHelper.COLUMN_NAME_ST, st);
    long insertId = database.insert(SQLiteDbHelper.TABLE_NAME, null, values);
        }})
        .setNegativeButton("No", null)
        .show();

  }