// Necessary :)
    private Context mContext;
    private View MyView;


    // Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
            @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    mContext=getActivity();
    if(MyView==null){

    // Layout View
    MyView=LayoutInflater.from(mContext).inflate(R.layout.fragment_profile, null);

    // Your views & Codes
    ConstraintLayout profile = (ConstraintLayout) MyView.findViewById(R.id.ll);
    ImageView imageView = (ImageView) MyView.findViewById(R.id.imageView3);
    imageView.setClipToOutline(true);
    SharedPreferences sharedPref = getActivity().getSharedPreferences("INFORMATION", 0);
    String USERNAME = sharedPref.getString("user","");
    TextView username = (TextView) MyView.findViewById(R.id.username);
    Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/Roboto Thin.ttf");
    TextView desc = (TextView) MyView.findViewById(R.id.desc);
    desc.setTypeface(custom_font);
    username.setTypeface(custom_font);
    username.setText(USERNAME);
    new PostClass(getContext()).execute();
    new PostClass_2().execute();
    new PostClass_3().execute();



    // Stop fragment reload [ When changing ]
      } ViewGroup parent = (ViewGroup) MyView.getParent();  
      if (parent != null) {  
           parent.removeView(MyView);  
           }  
        return MyView;
    }

}