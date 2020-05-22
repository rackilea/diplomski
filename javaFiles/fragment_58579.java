} catch (NumberFormatException e ) {
        new AlertDialog.Builder(getActivity())
          .setTitle("Error: incorrect number entered!")
          .setMessage("The exact error is: " + e.getMessage())
          .setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int b) {
                        dialog.cancel();
                    }
                });
          .create()
          .show();
}