DialogOrder.DialogListener listener = new DialogOrder.DialogListener() {
   @Ovveride
   public void onButtonClicked() {
     update_UI();
   }
};

DialogOrder dialogOrder = new DialogOrder(getActivity(), listener);
dialogOder.show();