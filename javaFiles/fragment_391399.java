@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // R.layout.my_layout - that's the layout where your textview is placed
    View view = inflater.inflate(R.layout.my_layout, container, false);
    TextView mTextView = (TextView) view.findViewById(R.id.colors);
    // you can use your textview.
    return view;
}