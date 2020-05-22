Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
    while (cursor.moveToNext()) {
        String contactId = cursor.getString(cursor.getColumnIndex(
                ContactsContract.Contacts._ID));

        //May want to get basic info here like name, phone
        //Example:
        //Cursor phones = getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId, null, null);
        //while (phones.moveToNext()) {
        //    String phoneNumber = phones.getString(phones.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER));
        //    Log.i("phone", phoneNumber);
        //}
        //phones.close();

        Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId, null, null);
        while (emails.moveToNext()) {
            String emailAddress = emails.getString(
                    emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));

            Log.i("emails", emailAddress);
        }
        emails.close();
    }
    cursor.close();