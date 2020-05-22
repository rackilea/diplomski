...
else if(e.getSource()==btnView){
    int num1 = Integer.parseInt(txtdept1.getText());
    int num2 = Integer.parseInt(txtdept2.getText());
    int num3 = Integer.parseInt(txtdept3.getText());
    int num4 = Integer.parseInt(txtdept4.getText());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num1; ++i) {
        sb.append("*");
    }
    txtdept1record.setText(sb.toString());

    sb = new StringBuilder(); //empty it.

    //Same thing (i'll show once)

    for (int i = 0; i < num1; ++i) {
        sb.append("*");
    }
    txtdept2record.setText(sb.toString());
    ...