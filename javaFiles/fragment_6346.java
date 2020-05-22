public View onCreateView(LayoutInflater inflater,
                  ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_more,container,false);

        Button button = view.findViewById(R.id.btnLogin);
        button.setOnClickListener(this);
        return view;

}