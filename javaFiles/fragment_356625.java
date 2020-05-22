public class MyFirstTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Declare your first fragment here
        return inflater.inflate(R.layout.my_first_fragment_layout, container, false);
    }
}