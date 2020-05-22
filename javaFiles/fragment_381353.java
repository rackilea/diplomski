@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
            String buttonID = "button_" + i + j;  
            Button btn = buttons[i][j];                
            outState.putCharSequence(buttonID, btn.getText());
        }
    }
}