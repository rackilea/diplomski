Optional<ButtonType> result = alert.showAndWait();
if(!result.isPresent())
    // alert is exited, no button has been pressed.
else if(result.get() == ButtonType.OK)
     //oke button is pressed
else if(result.get() == ButtonType.CANCEL)
    // cancel button is pressed