@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View rootView = inflater.inflate(R.layout.rating_system_fragment,container,false);
    ratingResult = (TextView) rootView.findViewById(R.id.textViewRating);
    ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);
    ratingBar.setOnRatingBarChangeListener(this);

    return rootView;
}