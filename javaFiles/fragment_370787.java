@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...

    new Handler().post(new Runnable() {
        @Override
        public void run() {
            Log.i("TAG", "when does this run?");
        }
    });

    ...
}