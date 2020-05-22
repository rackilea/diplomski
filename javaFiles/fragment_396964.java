double num1 = Double.parseDouble(textArea_price.getText());

double num2 = Double.parseDouble(textArea_quantity.getText());

String result = textArea_result.getText();
double oldResult = (result == "") ? 0 : Double.parseDouble(result);

double result = oldResult + num1 * num2;
textArea_result.setText(Double.toString(result));