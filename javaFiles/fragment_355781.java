@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.date_fragment, container, false);
    View tv = v.findViewById(R.id.text);
    ((TextView)tv).setText(readableDateFormat.format(date));

    // changes below
    TextView valueTV = new TextView(getActivity());
    valueTV.setText("hallo hallo");
    valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
    ((ViewGroup)v).addView(valueTV);

    return v;
}