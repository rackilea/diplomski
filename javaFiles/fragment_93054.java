for (int i = 10; i <= 14; i++)//Commands
{
    if (event.getSource() == b[i]) {
        if (result.getText().lastIndexOf(OperationOnScreen) != -1)//prevent exception
        {
            result.setText(result.getText().substring(0, result.getText().lastIndexOf(OperationOnScreen)) + s[i]);
        } else {
            Screen = result.getText();
            result.setText(result.getText() + s[i]);
        }