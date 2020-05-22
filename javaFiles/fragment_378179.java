@Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

//        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
//        tv.setText(getArguments().getString("msg"));


        final EditText woo = (EditText)v.findViewById(R.id.editText);

        Button btn = (Button) v.findViewById(R.id.tryBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment home = new SecondFragment();

                Bundle bundle = new Bundle();
                bundle.putString("Try", woo.getText().toString());
                home.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.first_frag, home);
                ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return v;
    }