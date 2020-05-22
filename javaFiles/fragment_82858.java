/**
 * read a single record from the database the matches the UPC-A code scanned.
 * if there is no match, do nothing.
 * @param rawContent
 * @return a brand name based on the matching UPC-A code that was scanned.
 */
public String getInfo(String rawContent) {
    String TAG = "Getinfo():";
    String content = "00" + rawContent;
    String brandName = "";
    Cursor cursor = database.rawQuery("SELECT name, upc12 from Barcodes WHERE '" + content + "' = upc12", null);
    if(cursor.getCount() > 0) {
        cursor.moveToFirst();
        brandName = cursor.getString(cursor.getColumnIndex("name"));

        cursor.close();
    } else {
        Log.v(TAG, "uh oh, something went wrong in the if loop! ");
    }

    return brandName;
}