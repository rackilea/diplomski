@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.hydration, parent, false);

    //Find your stuff from the inflated rootView of your Fragment
    CircularProgressBar progressBar = rootView.findViewById(R.id.circle_progressbar);
    //Do stuff with progressBar

    return rootView;
}