Set<Person> persons = new HashSet<>();

public void AddAllContacts(View view) {
    try {
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

    while (phones.moveToNext()) {
        String linesp = System.getProperty("line.separator");
        TextView quantityTextView = (TextView) findViewById(R.id.numbersview);
        String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        Person person = new Person(name, phoneNumber);
        persons.add(person);
    }
    phones.close();