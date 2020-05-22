@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_select_type, container, false);
}




@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

   Button btn = (Button) view.findViewById(R.id.btn);

    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            noVIP TextFragment = new noVIP();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, TextFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }); 

  }