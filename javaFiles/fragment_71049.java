@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

        SharedPreferences prefs =
                getSharedPreferences("StorageName", MODE_PRIVATE);
                //Always enter a default value for just in case the storage 
                 //value is empty
                String myStoredValue = prefs.getString(key,null);
    }
}