if (cursor != null) {
    Integer colIndex = cursor.getColumnIndex(KEY_USERNAME_DEVICE);
    // move cursor to first row
    if (cursor.moveToFirst()) {
        do {
            // Get version from Cursor
            infor = cursor.getString( colIndex );
            // add the bookName into the bookTitles ArrayList
            // move to next row
        } while (cursor.moveToNext());
    }
}