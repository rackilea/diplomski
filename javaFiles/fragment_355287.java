@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.my_fragment, container, false);

    mMyTextView = (TextView) view.findViewById(R.id.my_text_view);
}