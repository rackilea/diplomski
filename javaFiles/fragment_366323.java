@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details, container, false);
        TextView textView = (TextView) view.findViewById(R.id.detailsText);
        String text = "sample text";
        textView.setText(text);
        return view;
    }