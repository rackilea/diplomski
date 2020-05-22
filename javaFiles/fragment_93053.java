for (int i = 0; i <= 9; i++)//Numbers
{
    if (event.getSource() == b[i]) {
        Screen += i;
        result.setText("");
        result.setText(Screen);
    }
}