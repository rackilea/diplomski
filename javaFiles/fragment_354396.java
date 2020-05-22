button.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
    final int position = getAdapterPosition()
    //Your code here             
    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        alertDialog.dismiss();
        getPaymentMode(arrayList.get(position), button);
      }
    });
  }
});