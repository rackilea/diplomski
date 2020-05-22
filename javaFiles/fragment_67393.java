public class ChatFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chat_fragment_layout, container, false);
        // find the view by using its id and set a listener
        rootView.findViewById(R.id.table_row_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ChatFragment", "Hey, the user clicked table_row_1 !");
            }
        });
        return rootView;
    }
}