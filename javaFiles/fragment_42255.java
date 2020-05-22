// How to Respond to both Keys ("Z" and "X") pressed together.
ZAndXPressed.addListener(new ChangeListener<Boolean>()
{
  @Override
  public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
  {
    if (newValue == true)
    {
        i++;
        l1.setText(Integer.toString(i));
    }
  }
});