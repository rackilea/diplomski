@Override
public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, viewGroup, false);

    view.findViewById(R.id.emailSignInButton).setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        }
    });

    return view;
}