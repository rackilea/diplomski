@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_settings, container, false);
    // The frame you want to embed the parent layout in.
    final ViewGroup innerContainer = (ViewGroup) view.findViewById(R.id.main_frame);
    final View innerView = super.onCreateView(inflater, innerContainer, savedInstanceState);
    if (innerView != null) {
        innerContainer.addView(innerView);
    }
    return view;
}