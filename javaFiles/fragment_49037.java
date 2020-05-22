public class nominateContactsActivity extends Activity {
    // Add a list to keep all the "name: number" strings
    private List<String> mNameNumber = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nominatecontactslayout);
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String contactName, contactTelNumber = "";
        String contactID;

        // You only need to find these indices once
        int idIndex = c.getColumnIndex(ContactsContract.Contacts._ID);
        int hasNumberIndex = c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int nameIndex = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);


        // This is simpler than calling getCount() every iteration
        while(c.moveToNext()) {
            contactName = c.getString(nameIndex);
            contactID = c.getString(idIndex);

            // If this is an integer ask for an integer
            if (c.getInt(hasNumberIndex)) > 0) {
                Cursor pCur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] { contactID },null);
                while (pCur.moveToNext()) {
                    contactTelNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    // Store the "name: number" string in our list
                    mNameNumber.add(contactName + ": " + contactTelNumber);
                } 
            }
        }

        // Find the ListView, create the adapter, and bind them
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNameNumber);
        listView.setAdapter(adapter);
    }
}