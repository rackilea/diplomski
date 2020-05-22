new AlertDialog.Builder(this)
    .setTitle("No internet")
    .setCancelable(false)
    .setMessage("Message ")
    .setPositiveButton("Close", new DialogInterface.OnClickListener()
    {
      @Override
      public void onClick(DialogInterface dialogInterface, int w) {
        finish();
      }
    })
    .show();