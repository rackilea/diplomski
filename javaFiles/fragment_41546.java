public class BottomFragment extends Fragment {
    private Button mButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        mButton = (Button)view.findViewById(R.id.button);
        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Whatever you write inside here will get
                        // executed when you click on mButton
                    }
                }
        );
        return view;
    }
}