@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fregment_starting_point, container,false);

            dd = (Button) rootView.findViewById(R.id.btn_add);
        substract = (Button) rootView.findViewById(R.id.btn_subscract);
        display = (TextView) rootView.findViewById(R.id.txt_display);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter++;
                display.setText("Your total is " + counter);
            }
        });

        return rootView;
    }