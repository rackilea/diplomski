@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_layout, container, false);
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);        
    mListView = (ListView) getView().findViewById(R.id.listview);

    mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, a_string_array);
    mListView.setAdapter(mAdapter);
    mListView.setOnItemClickListener(this);

    ...
}