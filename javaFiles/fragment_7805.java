TextView textView
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.fragment_home, container, false);
    textView = v.findViewById(R.id.textView);
    return v;
}