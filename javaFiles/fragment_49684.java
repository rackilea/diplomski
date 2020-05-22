CheckBox FullScreen;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setcontentview(R.layout.settings);
    // initialize the checkbox, else nullpointer in if-condition (q2)
    FullScreen = (CheckBox)findViewById(R.id.myFullscreenCheckbox);
    if (FullScreen.isChecked()) {
        // make app fullscreen (q1)
        this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setcontentview(R.layout.settings);
    }
}