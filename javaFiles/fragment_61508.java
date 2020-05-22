Cursor cur = cr.query(
     ContactsContract.Contacts.CONTENT_URI, 
     null,
     ContactsContract.Contacts.DISPLAY_NAME + " like ?", 
     new String[]{ "%" + results.get(0) + "%"}, 
     null);