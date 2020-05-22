@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_info, container, false);

   TextView n = (TextView) view.findViewById(R.id.nama);
   n.setText("Some String");

   return view;
}