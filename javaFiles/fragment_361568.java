@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState
                    .getInt(STATE_ACTIVATED_POSITION));
        }
        mView = inflater.inflate(R.layout.frag_abc_sort, container, false);
        mABCListView = (IndexableListView) mView.findViewById(R.id.frag_abc);
        //...
        return mView;
    }

    public void replaceFrag(String[] List, boolean SetABCListScrollable) {
        mABCListView.setFastScrollEnabled(true);
        mABCListView.showList(SetABCListScrollable);
        ContentAdapter adapter = new ContentAdapter(mView.getContext(),
                android.R.layout.simple_list_item_1, List);
        mABCListView.setAdapter(adapter);
    }