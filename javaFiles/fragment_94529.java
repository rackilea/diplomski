Double val = Double.parseDouble(txt11.getText());
if (val < 50) {
    txt12.setText("F");
} else if (val <= 59) {
    txt12.setText("D");
} else if (val <= 64) {
    txt12.setText("C");
} else if (val <= 69) {
    txt12.setText("C+");
} else if (val <= 74) {
    txt12.setText("B");
} else if (val <= 79) {
    txt12.setText("B+");
} else if (val <= 84) {
    txt12.setText("A");
} else {
    txt12.setText("A+");
}