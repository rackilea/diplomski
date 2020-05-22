for (ContactEmail contactEmail : emails) {
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Email.ADDRESS, "a@a.com");
        values.put(ContactsContract.CommonDataKinds.Email.TYPE, type.home);
        contentResolver.insert(android.provider.ContactsContract.Data.CONTENT_URI, values);
    }