case SMS_DIALOG_ID:
    ...
    AlertDialog dialog2 = builder2.create();

    dialog2.setOnDismissListener(new OnDismissListener() {
        public void onDismiss(DialogInterface dialog) {
            ImportActivity.this.showDialog(SAVEORBACK_DIALOG_ID);
        }
    });

    return dialog2;
}