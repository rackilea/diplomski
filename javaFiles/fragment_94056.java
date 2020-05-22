@Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

     //Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.my_app_bar);
     //((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
     //return inflater.inflate(R.layout.fragment_training, container, false);

     View v = inflater.inflate(r.layout.fragment_training, container, false);
     Toolbar toolbar = (Toolbar) v.findviewbyid(r.id.my_app_bar);
     ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
     return v;
}