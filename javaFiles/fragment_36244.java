public class AFragment extends Fragment {

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);
        //moved to onCreate() method
        //setHasOptionsMenu(true);

        //set toolbar as the default for the activity class if AppCompat
        ((AppCompatActivity) getActivity()).setSupportActionBar(/*your toolbar goes here*/);

        //set toolbar is activity class is not AppCompat
        getActivity().setActionBar(/*your toolbar goes here*/);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_a, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_a) {
            //getFragmentManager().popBackStackImmediate();
        }
        return super.onOptionsItemSelected(item);
    }

}