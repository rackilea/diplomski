boolean darkTheme = true;

public void onCreate(Bundle savedInstanceState) {
    setTheme(darkTheme ? R.style.bgThemeDark:R.style.bgThemeLight);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
}