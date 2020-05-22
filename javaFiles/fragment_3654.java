@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.timer_frag, container, false);

    TextView text = (TextView) v.findViewById(R.id.pwd_status);
    /* set the TextView's text, click listeners, etc. */

    return v;
}