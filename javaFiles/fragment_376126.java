Date_TextField[Index].addFocusListener(new FocusListener()
{
  public void focusGained(FocusEvent e)
  {
    Out("Focus gained : "+e.toString());
    Focused_Date_TextField=(JTextField)e.getSource();
  }

  public void focusLost(FocusEvent e)
  {
    Out("Focus lost : "+e.toString());
  }
});