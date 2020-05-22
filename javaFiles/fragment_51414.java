public void showMessageDialog(Context context, int message, int title) {
    new AlertDialog.Builder(context)
    .setTitle(title)
    .setMessage(message)
    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO: Ok click stuff
        }
    })
    .setNegativeButton(R.string.cancel, null)
    .show();
}