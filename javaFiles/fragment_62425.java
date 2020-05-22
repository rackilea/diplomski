StringBuilder selectionArgStr = new StringBuilder();
for(String word : results) { 
   selectionArgStr.append(word);
   selectionArgStr.append(" ");
}

Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, 
   ContactsContract.Contacts.DISPLAY_NAME + "=?",
     new String[]{ selectionArgStr.toString() }, null);