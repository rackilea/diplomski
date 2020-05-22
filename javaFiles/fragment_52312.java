public KeyBoundButton(String actionMapKey, int key, int mask)
  {
    Action myAction = new AbstractAction()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        action(e);
      }
    };  

    setAction(myAction);
 setActionCommand(actionMapKey);//like this
 System.out.println(getActionCommand());
    getInputMap(WHEN_IN_FOCUSED_WINDOW)
                  .put(getKeyStroke(key, mask),actionMapKey);
    getActionMap().put(                        actionMapKey, myAction);

  }