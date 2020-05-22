public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.meat_adobo, container, false);
    Button b=(Button) v.findViewById(R.id.button);
    b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                 Intent in=new Intent(getActivity(),SecondActivity.class);
    startActivity(in);

            }
        });

    return v;
    }