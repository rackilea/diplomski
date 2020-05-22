@Override      
protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    if (android.provider.Settings.System.getInt(getContentResolver(),
            Settings.System.ACCELEROMETER_ROTATION, 0) == 1){
        Toast.makeText(getApplicationContext(), "Rotation ON", Toast.LENGTH_SHORT).show();

    }
    else{
        Toast.makeText(getApplicationContext(), "Rotation OFF", Toast.LENGTH_SHORT).show();
    }
    super.onCreate(savedInstanceState);
}