private List<Map<String, Object>> getAllContactNamesAndThumbs() {
    List<Map<String, Object>> namesAndThumbs;

    // Check the SDK version and whether the permission is already granted or not.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        namesAndThumbs = new ArrayList<Map<String, Object>>();
        //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
    } else {
        //The permissions are granted so Get all contacts
        namesAndThumbs = new ArrayList<Map<String, Object>>();
        try {
            Cursor contactCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER},
                    null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

            if (contactCursor != null) {

                while (contactCursor.moveToNext()) {

                    long id = contactCursor.getLong(contactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                    InputStream inputStream = openThumbnail(id);
                    Bitmap thumbnail;

                    if (inputStream != null) {
                        thumbnail = BitmapFactory.decodeStream(inputStream);
                    } else {
                        thumbnail = BitmapFactory.decodeResource(getResources(), R.drawable.ic_person_black_24dp);
                    }

                    //Add contact name into the list
                    Map<String, Object> datum = new HashMap<String, Object>(2);
                    datum.put("name", contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                    datum.put("thumbnail", thumbnail);
                    namesAndThumbs.add(datum);
                }
            }
        } catch (NullPointerException e) {
            Log.e("ContactNamesAndThumbs", e.getMessage());
        }
    }
    return namesAndThumbs;
}