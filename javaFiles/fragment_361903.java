@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);

    // Getting reference to listview
    ListView lstContacts = (ListView) rootView .findViewById(R.id.listview);

    // Setting the adapter to listview
    lstContacts.setAdapter(mAdapter);
    // add all the other code here

    return rootView;
}