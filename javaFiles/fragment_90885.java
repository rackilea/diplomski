final Button btOk = (Button) dlg.getDialogPane().lookupButton(ButtonType.OK);
 btOk.addEventFilter(ActionEvent.ACTION, event -> {
     if (!validateAndStore()) {
         event.consume();
     }
 });