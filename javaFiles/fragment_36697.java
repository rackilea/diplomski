ArrayList<KeyValue> list = new ArrayList<KeyValue>();

    Cursor cursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, ContactsContract.Contacts._ID +" = ?", new String[]{String.valueOf(recordId)}, null);
    while (cursor.moveToNext()) {
       String where = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
       String[] params = new String[] {String.valueOf(recordId), ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE};
       Cursor nickname = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, where, params, null); 
       while (nickname.moveToNext()) { 
            String nicknameName = nickname.getString(nickname.getColumnIndex(ContactsContract.CommonDataKinds.Nickname.NAME));
            String nicknameType = nickname.getString(nickname.getColumnIndex(ContactsContract.CommonDataKinds.Nickname.TYPE));
            switch (Integer.valueOf(nicknameType)) {
            case 1: nicknameType = "Default"; break;
            case 2: nicknameType = "OtherName"; break;
            case 3: nicknameType = "MaidenName"; break;
            case 4: nicknameType = "ShortName"; break;
            case 5: nicknameType = "Initials"; break;
            }
            list.add(new KeyValue("Nickname:" + nicknameType, nicknameName));
       }
       nickname.close();
    }
    return list;