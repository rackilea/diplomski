public class MyFragment extends Fragment {
....
private List<MyItem> myItems = new ArrayList<MyItem>();
....
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment__my_list, container, false);
    lv = (ListView)rootView.findViewById(R.id.my_list);

    // For example purposes, fill myItems with dummy data setting all checkboxes initially to false
    for (int i = 0; i < 10; i++) {
        MyItem myItem = new MyItem();
        myItem.label = "Item " + i;
        myItem.myItemCheckBoolean = false;
        myItems.add(myItem);
    }

    MyListAdapter adapter = new MyListAdapter(getActivity(), R.layout.my_list_item, myItems);
    adapter.setMyListAdapterListener( new MyListAdapter.MyListAdapterListener() {

        @Override
        public void onItemCheckClicked(int index) {
            Log.d("MyFragment", "Item " + index + " Check Clicked");
            // toggle the item's boolean
            myItems.get(index).myItemCheckBoolean = !myItems.get(index).myItemCheckBoolean;
        }

        @Override
        public void onItemLabelLongClicked(int index) {
            Log.d("MyFragment", "Item " + index + " Label LongClicked");
        }

    }

    lv.setAdapter(adapter);
    ....
    return rootView;
}