class ClassGetPhoneNumber {

    ...

    public static void retrieveContactNumber(Context context, Uri uriContact) {
        sResponse = null;
        sContactNumber = null;
        sContactNumberFinal = null;

        // get contactID from contactUri
        long contactID = ContentUris.parseId(contactUri);

        // Using the contact ID now we will get contact phone number
        // Don't add selection by Phone.TYPE as we might miss a lot of phones.
        // We ask for the normalized number, this will only work for API 16 and above
        Cursor cursorPhone = context.getContentResolver().query(CommonDataKinds.Phone.CONTENT_URI,
                new String[]{CommonDataKinds.Phone.NORMALIZED_NUMBER, CommonDataKinds.Phone.NUMBER},
                CommonDataKinds.Phone.CONTACT_ID + " = " + contactID,null,null);

        contactNumber = null;

        if (cursorPhone != null && cursorPhone.moveToFirst()) {
            contactNumber = cursorPhone.getString(0); // this number will always be of e164 format: "+<country><local number>"
            Log.d(TAG, "normalized number: " + contactNumber + ", original number: " + cursorPhone.getString(1) + ", contact-id: " + contactID);
        } else {
            // you need to quit here, otherwise you'll be using an old value of contactNumber in the rest of the code.
            if (cursorPhone != null) {
                cursorPhone.close();
            }
            return; 
        }

        cursorPhone.close();

        if (!TextUtils.isEmpty(contactNumber)) {
            sContactNumber = contactNumber;
            sContactNumberFinal = sContactNumber.substring(3);
            sResponse = sContactNumberFinal;
            sStatus = "OK";
        } else {
            // no phone was found
            sStatus = "NOT FOUND";
        }
    }
}