input.setOnKeyListener(new OnKeyListener()
{
public boolean onKey(View v, int keyCode, KeyEvent event)
{
    if (event.getAction() == KeyEvent.ACTION_DOWN)
    {
        switch (keyCode)
        {

            case KeyEvent.KEYCODE_ENTER:
                //your action
                Editable answer = input.getText();
                input.setVisibility(View.GONE);
                if (answer.equals(loadG1)){
                    score[0] += 1;
                }
                return true;
            default:
                break;
        }
    }
    return false;
}