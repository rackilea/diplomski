String dfname = getRealPathFromURI(uri);
File df = new File(dfname);
File dfolder = df.getParentFile();
if(!dfolder.exists()) dfolder.mkdirs();
if(!df.exists()) df.createNewFile();
FileOutputStream os = new FileOutputStream(df);

private String getRealPathFromURI(Uri contentURI) {
    Cursor cursor = this.cordova.getActivity().getContentResolver().query(contentURI, null, null, null, null);
    if (cursor == null) { // Source is Dropbox or other similar local file path
        return contentURI.getPath();
    } else { 
        cursor.moveToFirst(); 
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
        return cursor.getString(idx); 
    }
}