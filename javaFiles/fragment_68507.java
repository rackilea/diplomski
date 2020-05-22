private void saveContacts() {
    cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,
    ContactsContract.Contacts.DISPLAY_NAME + " ASC");

    while (cursor.moveToNext()){
        String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

        // Call the function here
        writeNewUser(contactName, phoneNumber);
    }

    cursor.close();
}