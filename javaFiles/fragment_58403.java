RadioGroup rgdSize,rgdRank;

 @Nullable
 @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable 
 ViewGroup container, @Nullable Bundle savedInstanceState) {

View view = inflater.inflate(R.layout.radio_button, container, false);

 rgdSize = view.findViewById(R.id.rdgSize);
 rgdRank = view.findViewById(R.id.rdgRank);

 Button btnSend;
btnSend = view.findViewById(R.id.btnSend);
btnSend.setOnClickListener(btnSendListener);

return view;
 }