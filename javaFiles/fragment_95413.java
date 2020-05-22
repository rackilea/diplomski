public class MyViewModel extends ViewModel
{
    // ...

    public void insert() throws Exception
    {
        db.execSQL(
            "INSERT INTO " + TABLE_NAME +
            " (" + COL2 + "," + COL3 + "," + COL4 + "," + COL5 + ")
            VALUES('" + nome + "', '" + password + "', 0, 0); ");
    }
}