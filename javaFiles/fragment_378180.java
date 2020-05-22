@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.second_frag, container, false);

    TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
    TextView tvTry = (TextView) v.findViewById(R.id.tvTry);

    Bundle arguments = getArguments();
    if (arguments != null) {
        String myValue  = arguments.getString("Try");
        tvTry.setText(myValue);
    }


    return v;
}