@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_profile, container, false);

    UserName = v.findViewById(R.id.textview_user_name);
    UserInfo = v.findViewById(R.id.textview_user_info);

    // Set the visibility to invisible here. So that when the application is loaded, you do not see the pre-set values. 
    UserName.setVisibility(View.INVISIBLE);
    UserInfo.setVisibility(View.INVISIBLE);

    mDatabase = FirebaseFirestore.getInstance();
    return v;
}