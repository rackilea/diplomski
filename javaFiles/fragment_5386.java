@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collegebulletin, null, false);

        tv = (TextView) rootView.findViewById(R.id.tagSample);
        ccs = (Button) rootView.findViewById(R.id.ccs);
        coe = (Button) rootView.findViewById(R.id.coe);

        return rootView;
    }