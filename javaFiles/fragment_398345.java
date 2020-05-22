new AlertDialog.Builder(Main.this)
               .setTitle("Enter password")
               .setMessage("Password required for this function")
               .setView(/* You view layout */)
               .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {
                       Editable value = input.getText(); 
                   }
               }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {
                       // Do nothing.
                   }
               }).show();