@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DisplayMetrics display = getResources().getDisplayMetrics();
    int width = display.widthPixels;
    int height = display.heightPixels;
}