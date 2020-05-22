ArrayList<Item> mDATAFROMA = new ArrayList<>(); 

@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle pb=getArguments();
        mDATAFROMA = pb.getParcelableArrayList("GET_LIST"); 
    }