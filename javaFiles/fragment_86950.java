gui.addPropertyChangeListener(new PropertyChangeListener() {

     @Override
     public void propertyChange(PropertyChangeEvent pcEvt) {

        // is the property being changed the one we're interested in?
        if (WampusGUI.USER_COMMAND.equals(pcEvt.getPropertyName())) {

           // get user command:
           String userCommand = pcEvt.getNewValue().toString();

           // then we can do with it what we want
           play(userCommand);

        }

     }
  });