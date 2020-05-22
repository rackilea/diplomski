private class Frag extends Fragment {

    private LocationQueries locationQueries;
    ...
    @Override
    public void onCreate(Bundle inState) {
        locationQueries = new LocationQueries(getActivity());
    }
}