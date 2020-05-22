public String get_name() {

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null);

        if (cur.getCount() > 0) {

            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

                    System.out.println("name : " + name + ", ID : " + id);
                    if (name.equals(number)) {
                        title_holder = name;
                        break;
                    }else{
                        title_holder = number;
                        break;
                    }

                }
            }
        }
        return title_holder;
    }