public class BLEFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        View view = inflater.inflate(R.layout.fragment_2_ble, container, false);
        ListView list = (ListView) view.findViewById(R.id.your_id);
        list.setOnClickListenre(...);
        return view;
    }
}