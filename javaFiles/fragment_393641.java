@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

View v = inflater.inflate(R.layout.fragment1, container, false);


    TextView textview = v.findViewById(R.id.textview);
    textview.setText(mParam1);

return v;

}