if(!firstFT.getText().equals("") && !secondFT.getText().equals("")){
    double num1 = ((Number)(firstFT.getValue())).doubleValue();
    double num2 = ((Number)(secondFT.getValue())).doubleValue();
    double result = num1 + num2;
    String answer = Double.toString(result);
    output.setText(answer);
}