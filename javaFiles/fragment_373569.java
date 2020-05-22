@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        Button regButton1 = (Button) rootView.findViewById(R.id.btnRegister);

        regButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Example action", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }