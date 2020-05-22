@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    //Getting the instance of Spinner and applying OnItemSelectedListener on it
    View view = inflater.inflate(R.layout.fragment_settings, container, false);

    Spinner spinnerBetrag = (Spinner) view.findViewById(R.id.spinnerBetrag);
    Spinner spinnerDetails = (Spinner) view.findViewById(R.id.spinnerDetails);

    spinnerBetrag.setOnItemSelectedListener(this);
    spinnerDetails.setOnItemSelectedListener(this);

    return view;  // add this instead
}