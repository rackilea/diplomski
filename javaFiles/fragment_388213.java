public class FiveFragment extends Fragment {

private ListView listView;
private String items[];

public FiveFragment() {

}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    items = getResources().getStringArray(R.array.list5);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_five, container, false);

    listView = (ListView) rootView.findViewById(android.R.id.list);
    CustomListAdapter adapter = new CustomListAdapter(getActivity(), items);
    listView.setAdapter(adapter);


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(getContext(), "You Clicked on: " + arg2, Toast.LENGTH_SHORT).show();
        }
    });

    return rootView;
}
}