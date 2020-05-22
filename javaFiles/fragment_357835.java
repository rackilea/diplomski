@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings_contacts);

    contactsList = (RecyclerView) findViewById(R.id.usersList);
    //Add the data first 
    addDataToList();
    linearLayoutManager = new LinearLayoutManager(getApplicationContext());
    //and then create a object and pass the lis
    mAdapter = new AdapterContacts(contacts);

    contactsList.setHasFixedSize(true);
    contactsList.setLayoutManager(linearLayoutManager);
    contactsList.setAdapter(mAdapter);
    mAdapter.notifyDataSetChanged();


}
public void addDataToList(){
final ArrayList<Contacts> contacts = new ArrayList<>();
    ContentResolver contentResolver = getContentResolver();
    Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
    if (cursor != null) {
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id},
                            null);
                    if (phoneCursor != null) {
                        if (phoneCursor.moveToNext()) {
                            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                            contacts.add(new Contacts(name, phoneNumber));
                            phoneCursor.close();
                        }
                    }
                }
            }
        }
        cursor.close();
    }
}
}