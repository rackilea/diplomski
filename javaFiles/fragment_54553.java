public void performBackup(final MainDatabase db, final String outFileName) {

    File folder = new File(Environment.getExternalStorageDirectory() + File.separator 
+ mContext.getResources().getString(R.string.app_name));

    boolean success = true;
    if (!folder.exists())
        success = folder.mkdirs();
    if (success) {

        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.backup_dialog);
        dialog.getWindow().getAttributes().windowAnimations = 
R.style.PauseDialogAnimation;

dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        Button btnSave = dialog.findViewById(R.id.btnSave);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        EditText etName = dialog.findViewById(R.id.etName);
        etName.setInputType(InputType.TYPE_CLASS_TEXT);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m_Text = etName.getText().toString();
                String out = outFileName + m_Text + ".db";

                db.backup(out);
                dialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    } else
        Toast.makeText(mContext, "Unable to create directory. Retry", 
Toast.LENGTH_SHORT).show();
}

    public void backup(String outFileName) {

    //database path
    final String inFileName = mContext.getDatabasePath(DATABASE_NAME).toString();

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

        Toast.makeText(mContext, "Backup Completed", Toast.LENGTH_SHORT).show();

    } catch (Exception e) {
        Toast.makeText(mContext, "Unable to backup database. Retry", 
Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
}