public int getSelection() {
   ButtonModel btnModel = bg.getSelection();
   if (bg == null) {
     // TODO: throw an exception -- no radio button has been selected
   } else {
      return Integer.parseInt(btnModel.getActionCommand());
   }
}