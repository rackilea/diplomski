@Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.some_list_view, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle b) {
        super.onViewCreated(view, b);

        // Button filter1 = (Button) view.findViewById(...);
        // filter1.setOnClickListener....

        EventAdapter adaptor = new EventAdapter(getActivity(), mOrganization);
        setListAdapter(adaptor);

        // This is like calling fetchList()
        ParseQuery.getQuery("Event").findInBackground(this);
    }

    @Override
    public void done(List<ParseObject> scoreList, ParseException e) {
        if (e == null) {
            ...
        }
    }