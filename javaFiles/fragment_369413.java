@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.theaterdetail_fragment,
            container, false);

    addListenerOnRatingBar(view);
    ........
  }