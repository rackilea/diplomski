public class MenuConcerts extends Fragment {

ArrayList<Concert> arrayConcert = new ArrayList<Concert>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concerts_layout, container, false);

        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_spelningar));
 // all the reading file logic here;
        ListAdapter listAdapter = new CustomerAdapter(getActivity(), arrayConcert);

        return view;
    }
}