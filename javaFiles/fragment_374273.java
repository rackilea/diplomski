final static String PLACES_ID = "GoogePlaces";

    //Creates fragment object with details

    public static PlaceFragment newInstance(GoogePlaces place) {
            PlaceFragment fragment = new PlaceFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(PLACES_ID, place);
            fragment.setArguments(bundle);

            return fragment;
        }

//this bit got a bit messy for me - welcome to comment with improvements 

   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        place = (GoogePlaces) getArguments().getSerializable(PLACES_ID);



 View view = inflater.inflate(R.layout.activity_place_detail, container, false);

    this.context = getActivity().getApplicationContext();

    Log.i("PLACE EXAMPLE", "Place Detail Activity");


        place = (GoogePlaces) getArguments().getSerializable(PLACES_ID);
...

        getActivity().setTitle(place.getName());
        String placesKey = getResources().getString(R.string.places_key);

//connect to google places - to gather eatery details
        String placesRequest = "https://maps.googleapis.com/maps/api/place/details/json?" +
                "key=" + placesKey + "&reference=" + place.getReference();
        PlacesDetailReadFeed detailTask = new PlacesDetailReadFeed();
        detailTask.execute(new String[]{placesRequest});

       ......

    return view;
    }