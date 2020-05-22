@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    accessDataBase();
    view = inflater.inflate(R.layout.fragment_notifications, container, false);
    swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
    swipeLayout.setOnRefreshListener(this);
    swipeLayout.setColorSchemeColors(android.R.color.holo_green_dark,
            android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark);
    return view;

}