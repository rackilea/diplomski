int a = Integer.parseInt(cijenaIgraca.getText());
int b = Integer.parseInt(kapital.getText());
if(b < a) {
    this.porukica.setText("Usli ste u minus, imacete troskove!");
} else {
    String c = String.valueOf(b-a);
    this.kapital.setText(c);
}