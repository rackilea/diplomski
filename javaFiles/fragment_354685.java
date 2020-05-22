private static final int[] BUTTONS_IDS = new int[] {R.id.imageButton0, R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4, R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9};

ImageButton[] buttons = new ImageButton[BUTTON_IDS.length];

private void initialiseButtons() {
    for (int i = 0; i < BUTTONS_IDS.length; i++) {
        buttons[i] = (ImageButton) findViewById(BUTTONS_IDS[i]);
        buttons[i].setOnClickListener(this);
    }
}