Button button = (Button) rootView.findViewById(R.id.saleentry);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {           
           Fragment fragment = new SentFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.remove(new PrimaryFragment ());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            }
        });