private Inform_dbHandler inform_dbHandler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        getActivity();
        mBaseView=inflater.inflate(R.layout.fragment_inform_list, null);
        findView();
        init();
        Inform_dbHandler inform_dbHandler  = new Inform_dbHandler(getActivity());

        return mBaseView;       
    }