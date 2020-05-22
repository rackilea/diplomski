Button button;

        @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                View vv = inflater.inflate(R.layout.fragment_quote_type, container, false);

            button = vv.findViewById(R.id.submitbutton);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

             return vv;
            }