public class FragmentA extends Fragment {

    public FragmentA() {
       setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragmenta_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}