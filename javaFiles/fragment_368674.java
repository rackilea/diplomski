public Uri getAlbumUri(Context mContext,String album_id){
    if(mContext!=null) {
        Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
        Uri imageUri = Uri.withAppendedPath(sArtworkUri, String.valueOf(album_id));
        return imageUri;
    }
    return null;
}