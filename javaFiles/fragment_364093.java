public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout_one, container, false);
    FragmentTransaction transaction = getFragmentManager().beginTransaction();

    button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              transaction.replace(R.id.fragment_container, newFragment);
              transaction.commit(); 
           }
        });
    return view;
}