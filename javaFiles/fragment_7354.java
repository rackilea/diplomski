@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_flight, container, false);
    depDate = (TextView) root.findViewById(R.id.book_f_dep);
    depDate.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }
});
return root;

}