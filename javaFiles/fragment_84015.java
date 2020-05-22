public void commandAction(Command command, Displayable display) {

      if(command==List.SELECT_COMMAND){                 
        String menuItem = this.getString(menuIndex);
      }

      if(command==select){       
        if( menuItem.equals("Register"))
     display.setCurrent(new RegisterScreen())
 }
      }