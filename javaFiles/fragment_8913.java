public class DummyFragment extends Fragment {

    private LinearLayout root;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout = (LinearLayout)  inflater.inflate(R.layout.dummy_fragment_layout, container, false);
        return root;
    }

}