.setPositiveButton("No",
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
            // do nothing - just continue
            ImportActivity.this.showDialog(SAVEORBACK_DIALOG_ID);
        }
    })
// etc, etc