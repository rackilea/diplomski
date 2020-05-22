String[] values = ( input.getText().toString().split(","));
String inLineValues = "";
for (String value : values) {
    inLineValues += value + "<br/>";
}
jLabel1.setText("<html>" + inLineValues + "</html>");