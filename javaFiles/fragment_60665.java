public View onCreateView(LayoutInflater inflater, ViewGroup fragment_container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view2 = inflater.inflate(R.layout.fragment_search,fragment_container,false);
    Bundle args = getArguments();
    drugButton = (Button) view2.findViewById(R.id.drugButt);
    System.out.println(drugButton);
    if(args != null)
    {
        String drug = args.getString("resultKey");
        drugButton.setText(drug);
    }

    return inflater.inflate(R.layout.fragment_result, fragment_container, false);
}