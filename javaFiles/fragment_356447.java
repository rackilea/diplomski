private String getContact(String ph)
    {
        String contactName = null;
        try{
            Uri uri = Uri.withAppendedPath(
                    PhoneLookup.CONTENT_FILTER_URI,
                    Uri.encode(ph));
            ContentResolver cr=getActivity().getContentResolver();
            Cursor cursor1 = cr.query(uri, new String[]{PhoneLookup.DISPLAY_NAME,PhoneLookup.PHOTO_URI}, null, null, null);
            if (cursor1 == null) {
                return "";
            }

            if(cursor1.moveToFirst()) {
                contactName = cursor1.getString(cursor1.getColumnIndex(PhoneLookup.DISPLAY_NAME));
                image_uri=cursor1.getString(cursor1.getColumnIndex(PhoneLookup.PHOTO_URI));
                cursor1.close();
            }
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return contactName;
    }