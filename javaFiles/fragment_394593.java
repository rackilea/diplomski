new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.CustomAlertDialog))
  .setSingleChoiceItems(new String[] {"One", "Two", "Three", "Four"}, 2,
    new DialogInterface.OnClickListener(){
      @Override
      public void onClick(DialogInterface dialog, int index) {
        // ...
        dialog.dismiss();
      }
    })
  .create()
  .show();