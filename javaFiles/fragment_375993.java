final String demDigits = digits.getText().toString().trim();

for (int i = 0; i < Numbers.length; i++) {
    boolean mustBreak = false;
    for(int j = 0; j < Numbers[i].length; j++ ) {
        if (demDigits.equals(Numbers[i][j])) {
            console.setText("works");
            mustBreak = true;
            break;
        }
        else {
            console.setText("nope");
        }
    }
    if (mustBreak) { break; }
}