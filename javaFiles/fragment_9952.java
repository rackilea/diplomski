@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

View rootView = inflater.inflate(R.layout.yourxml, container, false);

ListView lv = (ListView)rootView.findViewById(R.id.list);
lv.setAdapter(youradapter);

return rootView;
}