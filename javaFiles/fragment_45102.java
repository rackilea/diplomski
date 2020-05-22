UserBoxGlbImageAdapter adapter; 

    public UserBoxGLBFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("OnViewCreated:" , "OnViewCreated called successfully!");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_box_glb, container, false);
        adapter = new UserBoxGlbImageAdapter(getActivity());

        return view;
    }