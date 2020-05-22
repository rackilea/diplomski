public class Blah extends Activity {
  ...
  public void drawTable() {
    TableLayout table = (TableLayout)findViewById(R.id.tableLayout);
    ... // initialize all views as before
    DatabaseHelper helper = new DatabaseHelper(this);
    SQLiteDatabase db = helper.openDb();

    Cursor scores = helper.getScore(db);
    Cursor percentages = helper.getPercentage(db);
    ... // do something with the Cursors
    ..
    // finally
    scores.close();
    percentages.close();
    helper.closeDb(db);
  }
  ...
}