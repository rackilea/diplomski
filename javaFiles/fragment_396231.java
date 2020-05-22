@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view); //this is wrong! here view is your fragment you must access the nav view using getActivity() method 
View headerView = (NavigationView) navigationView.getHeaderView(0);
        ImageView drawerImage = (ImageView) headerView.findViewById(R.id.header_image);
        drawerImage.setImageResource(R.drawable.header_img2);
        getActivity().setTitle("Our Projects");
        super.onViewCreated(view, savedInstanceState);
    }


//Try replacing with this
NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view); //if your fragment is bound to the activity containing navigation drawer