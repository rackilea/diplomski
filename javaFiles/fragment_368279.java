@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button b=(Button)rootView.findViewById(R.id.button1);
        b.setText("why so serious ?");
        return rootView;
 }