public void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);

  setTheme(R.style.MyTheme); // (for Custom theme)
  setTheme(android.R.style.Theme_Holo); // (for Android Built In Theme)

  this.setContentView(R.layout.myactivity);