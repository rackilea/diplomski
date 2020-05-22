deleteBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {

        // you know the condition will be true,
        // but for formal reasons make sure anyway:
        if (context instanceof MyActivity)
        {
            new AlertDialog.Builder((MyActivity)context)
                    .setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this entry?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                     // and so on...
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
     }
});