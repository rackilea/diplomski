public class DisplayItemsFragment extends ListFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getContacts();

    }

    //Get the contacts in the phone
    public void getContacts(){
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactNumbers.add(phoneNumber);
            contactNames.add(name + "\n" + phoneNumber);
        }
        phones.close();
        displayContacts();
    }

    //displaying contacts name and numbers in a listView
    public void displayContacts(){
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, contactNames));
    }
}