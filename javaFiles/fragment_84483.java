@SuppressLint("NewApi") or @TargetApi(HONEYCOMB)

public void onCreate(Bundle savedInstance){

 if (android.os.Build.VERSION.SDK_INT >= VERSION_CODES.HONEYCOMB){
    getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}