public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    int position;

    try {
        position = getArguments().getInt(ARG_POSITION);
    } catch (NullPointerException e) {
        position = -1;
    }

    Log.d("BUNDLE", "position: " + position);

    ...
}