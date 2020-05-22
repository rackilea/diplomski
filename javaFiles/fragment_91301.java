if (savedInstanceState == null) {
        Fragment newFragment = new YourFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_frame, newFragment);
        ft.addToBackStack(null);
        ft.commit();
    }