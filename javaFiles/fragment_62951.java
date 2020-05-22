@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_activity_layout);

    // ...

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    if(prefs.getBoolean("show_dialog", true)) {
        showDialog();
    }
}

private void showDialog() {
    ConnectionDialogFragment dialog = new ConnectionDialogFragment();
    dialog.show(getSupportFragmentManager(), "connection_dialog");
}