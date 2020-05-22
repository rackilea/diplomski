@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.percentage_calc);

    /** Initialize variables for widget handles */
    ...
    View v = findViewById(R.id.percentage_calc_container);
    keypad.initializeWidgets();
}