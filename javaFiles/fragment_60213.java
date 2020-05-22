View view;
     Framelayout fContainer;
     @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          view = inflater.inflate(R.layout.fragment_layout, container, false);

        return startView();
      }

      public View startview(){
        fContainer = (Framelayout) view.findViewById(R.id.container);
        listView = (ListView) view.findViewById(R.id.noteList);
        listAdapter = new ListAdapter(context,image,titleText,subTitleText);
        listView.setAdapter(listAdapter);
        return view;
    }


public void childfragment(){
        fContainer.removeAllViews();
        Fragment childFragment = new FragmentList(context);
        FragmentTransaction transaction = 
        getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container, childFragment).commit();    
    }