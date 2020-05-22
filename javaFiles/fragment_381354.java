@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_player2);
    int playerX = Color.parseColor("#e8e5e5");
    int playerO = Color.parseColor("#737374");
    for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
            String buttonID = "button_" + i + j;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i][j] = findViewById(resID);
            buttons[i][j].setOnClickListener(this);
            if (savedInstanceState != null) {
                 String btnState = savedInstanceState.getCharSequence(buttonID);
                 if (btnState.equals("X")) {
                     // this is player X
                     buttons[i][j].setTextColor(playerX);
                 } else if (btnState.equals("O")) {
                     // this is player O
                     buttons[i][j].setTextColor(playerO);
                 } else {
                     // unclicked btn, do you have another color? 
                 }
            }
        }
    }