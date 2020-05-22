public static class PlaceholderFragment extends Fragment {
    ListView lv;
String[] days = new String[] { "Sunday", "Monday", "Tuesday",
    "Wednesday", "Thursday", "Friday"};

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
            lv = (ListView) view.findViewById(R.id.listView1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(GetActivity(),
            android.R.layout.simple_list_item_1, days);

            lv.setAdapter(adapter);
        return rootView;
    }
}