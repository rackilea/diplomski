@Override
    public View onCreateView(LayoutInflater inflater, 
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event, 
                container, false);
        // Check for an open session
        Session session = Session.getActiveSession();
        if (session != null && session.isOpened()) {
            // Get the user's data
            ShowEventsFromFQL();

        }
        return view;
    }