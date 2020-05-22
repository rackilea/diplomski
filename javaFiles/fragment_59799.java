@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


  View v = inflater.inflate(R.layout.fragment_tab1, container, false);

  btn0 = v.findViewById(R.id.btn0);     /// use created View here
  btn1 = v.findViewById(R.id.btn1);

  // and so on...


  // return created view
  return v;
}