AutoCompleteTextView act = 
                        (AutoCompleteTextView)findViewById(R.id.act_contact);
    ContentResolver content = getContentResolver();
    Cursor cursor = content.query(
                            ContactsContract.Contacts.CONTENT_URI, 
                            PEOPLE_PROJECTION, null, null, null);
    ContactListAdapter adapter = new ContactListAdapter(this, cursor);
    act.setAdapter(adapter);