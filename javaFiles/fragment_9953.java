@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
      // This part should be in the activity who handle the fragment
      /*if(savedInstanceState==null){
          getFragmentManager().beginTransaction().replace(R.id.content,new HomeFragment()).commit();
      }*/ 
        return rootView;
    }