public class MainFragment extends Fragment{

    public boolean nullView = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return nullView ? null : inflater.inflate(R.layout.fragment_main, container, false);
    }
}