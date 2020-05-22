String[] projection = new String[] { Phone.CONTACT_ID, Phone.DISPLAY_NAME, Phone.NUMBER };
Cursor c = cr.query(Phone.CONTENT_URI, projection, null, null, null);
while (c.moveToNext()) {
   long contactId = c.getLong(0);
   String name = c.getString(1);
   String phone = c.getString(2);
   Log.i("Phones", "got contact phone: " + contactId + " - " + name + " - " + phone);
}
c.close();