@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DummyContent dc = new DummyContent(getActivity()); 
    // do the parsing in the DummyContent: dc.doParsing()
    mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
        android.R.layout.simple_list_item_1, android.R.id.text1,
        DummyContent.ITEMS); // assuming that you keep the ITEMS ArrayList static
}