@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    manager = MyApplication.class.cast(getApplicationContext()).getManager();
    Token token = manager.getToken();
    if(null == token) {
        Log.w("MyActivity", "Token is null");
        Intent intent = new Intent(this, LauncherActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }
    ...
}