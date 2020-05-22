public class FirstFragment extends Fragment implements OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        Button nextButton = (Button) view.findViewById(R.id.button_first);
        nextButton.setOnClickListener(this);
        return view;
    }
}