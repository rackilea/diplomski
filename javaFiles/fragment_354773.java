@Override
public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_main);

    handler.postDelayed(updateCurrentTime, 500);

}