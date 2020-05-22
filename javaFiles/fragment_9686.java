btnSendForm.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             writeToSDFile();
                             }
                    });
@Override
protected void onCreate(Bundle savedInstanceState) {

private void writeToSDFile(){

    // Find the root of the external storage.
    // See http://developer.android.com/guide/topics/data/data-  storage.html#filesExternal

    File root = android.os.Environment.getExternalStorageDirectory();
    //tv.append("\nExternal file system root: "+root);

    // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

    File dir = new File (root.getAbsolutePath());
    dir.mkdirs();
    File file = new File(dir, "myData.txt");

    try {
        FileOutputStream f = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(f);
        String stringeventname = editEventName.getText().toString();


        pw.println("Event Name: "+stringeventname);
        pw.println("Hello");
        pw.flush();
        pw.close();
        f.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Log.i(TAG, "******* File not found. Did you" +
                " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
    } catch (IOException e) {
        e.printStackTrace();
    }
    //tv.append("\n\nFile written to "+file);
}