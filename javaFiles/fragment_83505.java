ContentResolver cr = getContentResolver();
    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
            null, null, null);
    String aNameFromContacts[] = new String[cur.getCount()];
    String aNumberFromContacts[] = new String[cur.getCount()];
    int j = 0;
    if (cur.getCount() > 0) {
        while (cur.moveToNext()) {
            String id = cur.getString(cur
                    .getColumnIndexOrThrow(ContactsContract.Contacts._ID));
            String name = cur
                    .getString(cur
                            .getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));

            if (("1")
                    .equals(cur.getString(cur
                            .getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER)))) {
                Cursor pCur = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                + " = ?", new String[] { id }, null);
                int i = 0;
                int pCount = pCur.getCount();
                String[] phoneNum = new String[pCount];
                String[] phoneType = new String[pCount];
                while (pCur.moveToNext()) {
                    phoneNum[i] = pCur
                            .getString(pCur
                                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    phoneType[i] = pCur
                            .getString(pCur
                                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.TYPE));

                    i++;
                }
                if (phoneNum.length > 0) {
                    aNumberFromContacts[i] = phoneNum[0];
                    aNameFromContacts[j] = name;
                    Log.d("name = ", "" + name +", phoneNumber = " + phoneNum[0]);
                }
            }
            j++;
        }
    }