@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

View rootView = inflater.inflate(R.layout.fragment_home, container, false);

ImageButton imageButton = (ImageButton)rootView.findViewById(R.id.imageButton1);
imageButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(), IniciarHome.class);
        startActivity(intent);
    }
});

return rootView;

}