/**
 * helper to retrieve the path of an image URI
 */
public String getPath(Uri uri) {
    // just some safety built in
    if( uri == null ) {
        // TODO perform some logging or show user feedback
        return null;
    }
    // try to retrieve the image from the media store first
    // this will only work for images selected from gallery
    String[] projection = { MediaStore.Images.Media.DATA };
    Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
    if( cursor != null ){
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    // this is our fallback here
    return uri.getPath();
}