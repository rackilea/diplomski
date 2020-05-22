SQLiteHandler db;

@Override 
public void onCreate() {
    super.onCreate() 
    SQLiteHandler db = new SQLiteHandler(getApplicationContext());
     ....rest of db calls..
}