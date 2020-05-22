try{
    double value = Double.parseDouble(textBoxF.getText());
    double answer = value * 9 / 5 + 35;
              textBoxC.setText(String.valueOf(answer));
}
catch (Exception e){
//What should happen when the input string is no double?
}