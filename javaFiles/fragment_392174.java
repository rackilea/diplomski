public class Tab1Fragment extends Fragment {

    Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        button = getActivity().findViewById(R.id.buttonTaureauBrute);
        textView = getActivity().findViewById(R.id.textView3);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if( view.getVisibility() == View.GONE ) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.GONE);
                }
            }
        };

        return view;
    }

}