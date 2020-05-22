//It requires a file manager installed
private void showFileChooser() {
    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType("file/*");
    try {
        startActivityForResult(intent, FILE_SELECT_CODE);
    } catch (android.content.ActivityNotFoundException ex) {
        Snackbar.make(uploadView, "No file manager founded!", Snackbar.LENGTH_LONG).setAction("Response", null).show();
    }

}//showFileChooser

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    switch (requestCode) {
        case FILE_SELECT_CODE:
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                uriToUpload = uri;
            }
            break;
    }
    super.onActivityResult(requestCode, resultCode, data);

}//onActivityResult 

private byte[] getFileData() throws IOException{

    Cursor cursor = getContentResolver().query(uriToUpload, null, null, null, null);
    cursor.moveToFirst();
    long size = cursor.getLong(cursor.getColumnIndex(OpenableColumns.SIZE));
    cursor.close();
    InputStream stream = getContentResolver().openInputStream(uriToUpload);
    byte[] data = new byte[(int)size];
    stream.read(data);
    stream.close();

    return data;

}//getFileData