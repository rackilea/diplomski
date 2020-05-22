btnTest.addListener(new ChangeListener()
{
  public void changed(ChangeEvent event, Actor actor)
  {
    new Dialog("Test Dialog", globals.skin, "dialog")
    {

    {
       //Things like this.getButtonTable().add(Actor);
    }

      protected void result (Object object)
      {
        if (object.equals(true))
        {
          if (txtID.getText() != "")
          {
             globals.appState = AppState.INTRO;
          }
        }
      }
    }.text("Enter ID")
     .button("Cancel", false)
     .button("OK", true)
     .show(stage);
  }
});