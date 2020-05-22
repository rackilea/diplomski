public void performRestore(final MainDatabase db) {


    File folder = new File(Environment.getExternalStorageDirectory() + File.separator 
+ mContext.getResources().getString(R.string.app_name));
    if (folder.exists()) {

        final File[] files = folder.listFiles();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mContext, 
 android.R.layout.select_dialog_item);
        for (File file : files)
            arrayAdapter.add(file.getName());
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(mContext);

        builderSingle.setTitle("Select & Restore ");
        builderSingle.setNegativeButton("cancle", (dialog, which) -> 
dialog.dismiss());
        builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
            try {
                db.importDB(files[which].getPath());
            } catch (Exception e) {
                Toast.makeText(mContext, "Unable to restore. Retry", 
Toast.LENGTH_SHORT).show();
            }
        });

        builderSingle.show();
    } else
        Toast.makeText(mContext, "Backup folder not present.\nDo a backup before a 
restore!", Toast.LENGTH_SHORT).show();
}

 public void importDB(String inFileName) {

    final String outFileName = mContext.getDatabasePath(DATABASE_NAME).toString();

    try {

        File dbFile = new File(inFileName);

        FileInputStream fis = new FileInputStream(dbFile);

        // Open the empty db as the output stream
        OutputStream output = new FileOutputStream(outFileName);

        // Transfer bytes from the input file to the output file
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        // Close the streams
        output.flush();
        output.close();
        fis.close();

        Toast.makeText(mContext, "Restore Completed", Toast.LENGTH_SHORT).show();

    } catch (Exception e) {
        Toast.makeText(mContext, "Unable to import database. Retry", 
Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
}