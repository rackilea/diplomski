@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragment_conversation, container, false);

        ListAdapter listAdapter = new Adapter_ConversationFragmentAdapter(getActivity(), R.layout.items_conversation,myFragmentView);
        setListAdapter(listAdapter);

        return myFragmentView;
    }