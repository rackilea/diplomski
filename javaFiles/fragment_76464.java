class MyActivity {
    static Intent createIntent(Context context, param1, param2, param3...) {
       Intent intent = new Intent(context);
       intent.setExtra("param1", param1);
       ...
       return intent;
}