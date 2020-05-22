String id = cur.getString(cur
  .getColumnIndex(ContactsContract.Contacts._ID));
String name = cur
  .getString(cur
    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

image_uri = cur
  .getString(cur
    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
if (Integer
  .parseInt(cur.getString(cur
    .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
 //System.out.println("name : " + name + ", ID : " + id);

 // NOW query all numbers of that particulat contact using contact_Id
 Cursor pCur = getContentResolver().query(
   ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
   null,
   ContactsContract.CommonDataKinds.Phone.CONTACT_ID
     + " = ?", new String[] { id }, null);
 while (pCur.moveToNext()) {
 // you can store phone in a arrayList
  phone = pCur
    .getString(pCur
      .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
  //System.out.println("phone" + phone);
 }
 pCur.close();
 }