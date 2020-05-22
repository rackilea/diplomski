AlertDialog.Builder builder = new AlertDialog.Builder(Activity.this);
try {
    builder.setMessage(readFile(context.getFilesDir().getAbsolutePath() + "/filename"))
           .setCancelable(true)
           .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
               }
           }).show();
} catch (IOException e) {
    Toast.makeText(Activity.this, "Error", Toast.LENGTH_SHORT).show();
    e.printStackTrace();
}