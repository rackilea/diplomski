AutoCompleteField acf = new AutoCompleteField(list) {
     protected void onSelect(Object selection, int type) {
        super.onSelect(selection, type);
        if (selection != null) {
          String selectionAsString = getEditField().getText();
          Thread worker = new Thread(new PostRequest(selectionAsString));
          worker.start();
        }
     }
  };