@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myfragment =  inflater.inflate(R.layout.fragment_ussd, container, false);
        //getting error at thus part "cannot resolve setcontentview"
        l1=(ListView)myfragment.findViewById(R.id.listView);
        l1.setAdapter(new dataListAdapter(t1,d1,i1));
        return myfragment;
        }