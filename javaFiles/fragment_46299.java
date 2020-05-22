int counter;
    Button add,subtract;
    TextView textview;
    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);   
        add = (Button)rootView.findViewById(R.id.bAdd);
        subtract=(Button)rootView.findViewById(R.id.bSubtract);
        textview=(TextView)rootView.findViewById(R.id.name);
        ... // rest of the code

        return rootView;
    }
}