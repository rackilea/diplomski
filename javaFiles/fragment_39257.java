@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
       Bundle savedInstanceState) {
    View root= inflater.inflate(R.layout.calendar_month_grid, container, false);
    mPageNumber = getArguments().getInt(ARG_PAGE);
    System.out.println("in onCreateView: "+mPageNumber);
    mTextView = (TextView)root.findViewById(R.id.fragmentDataTextView);
    mTextView.setText(String.valueOf(mPageNumber));
    return root;
}