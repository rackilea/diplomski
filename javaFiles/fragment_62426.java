StringBuilder selectionStr = new StringBuilder();
int resultLen = results.size();
for(int i=0; i<resultLen; i++) { 
   selectionStr.append(ContactsContract.Contacts.DISPLAY_NAME);
   selectionStr.append("=?");
   if(i>0 && i<(resultLen -1)) // Put OR only if there are more than one
     selectionStr.append(" || ");
}


Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, 
   selectionStr,
     (String [])results.toArray(), null);