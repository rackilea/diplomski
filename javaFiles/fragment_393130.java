public View onCreateView(LayoutInflater inflater,
  ViewGroup container, Bundle savedInstanceState) {
   View contentView = inflater.inflate(
          R.layout.home_fragment, container, false);
   //Inflate the layout for this fragment
     ViewGroup card1 = (ViewGroup)  contentView.findViewById(R.id.card1);
          TextView ct1 = (TextView) card1.findViewById(R.id.title);
          ct1.setText("hey :P");

  return contentView;