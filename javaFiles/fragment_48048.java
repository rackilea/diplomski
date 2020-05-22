@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_games, container, false);
    return rootView;
}


@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    myUIUpdate(view);
}