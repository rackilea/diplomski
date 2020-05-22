public class FragmentFavourites extends Fragment{

ArrayList<String> name = new ArrayList<String>();
ArrayList<String> number = new ArrayList<String>();
GridView f_list;
String starred_id,starred_name,starred_number;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);
    f_list=(GridView) rootView.findViewById(R.id.grid);
    name.clear();
    number.clear();
    try
    {
        new GetFavouriteTask().execute();
    }
    catch(Exception e)
    {
        Toast.makeText(getActivity(),"Problem Loading Contacts",Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
    return rootView;

}

public class GetFavouriteTask extends AsyncTask<Void,Void,Void>{

    @Override
    protected Void doInBackground(Void... params) {
        getFavourites();
        return null;
    }
    @Override
    protected void onPostExecute(Void result)
    {
        try {
            FavouriteAdapter fa=new FavouriteAdapter(getActivity(),name,number);
            f_list.setAdapter(fa);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}

public void getFavourites()
{
    ContentResolver cr = getActivity().getApplicationContext().getContentResolver();
    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
            new String[]{ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts.HAS_PHONE_NUMBER,
                    ContactsContract.Contacts.STARRED}, ContactsContract.Contacts.STARRED + "='1'", null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " COLLATE NOCASE ASC");

    while (cur.moveToNext()) {

        starred_id = cur.getString(0);
        starred_name = cur.getString(1);
        name.add(starred_name);
        starred_number=getFavouriteNumber(starred_id);
        number.add(starred_number);

    }
    cur.close();
}

public String getFavouriteNumber(String contactId)
{
    ContentResolver cr = getActivity().getApplicationContext().getContentResolver();
    String phone=null;

    Cursor cursor = cr.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
            new String[]{contactId}, null);

    while (cursor.moveToNext())
    {
        phone=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
    }

    cursor.close();
    return phone;
}
}