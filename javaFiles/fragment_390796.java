@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.item, container, false);
    titleTxt = (TextView)   view.findViewById(R.id.title);
    return view;
}