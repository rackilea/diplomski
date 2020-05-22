public void showMessageBox(Context context, String title, String  message, final MessageBoxListener listener) {
    new AlertDialog.Builder(context)
        .setTitle(title.toString())
        .setMessage(message.toString())
        .setCancelable(false)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.result(1);
                //dialogInterface.cancel();
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.result(2);
                //dialogInterface.dismiss();
            }
        })
        .show();
}