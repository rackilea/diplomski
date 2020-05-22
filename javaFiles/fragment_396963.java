double num1 = Double.parseDouble(textArea_price.getText());

double num2 = Double.parseDouble(textArea_quantity.getText());

double oldResult = 0;
String result = textArea_result.getText();
if (result  != "")
    oldResult = Double.parseDouble(result);

double result = oldResult + num1 * num2;
textArea_result.setText(Double.toString(result));