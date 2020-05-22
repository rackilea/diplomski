public static final boolean isMediaScannerScanning(final ContentResolver cr) {
    boolean result = false;
    final Cursor cursor = query(cr, MediaStore.getMediaScannerUri(), new String[] { MediaStore.MEDIA_SCANNER_VOLUME }, null,
            null, null);
    if (cursor != null) {
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            result = "external".equals(cursor.getString(0));
        }
        cursor.close();
    }
    return result;
}