@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getChildFragmentManager().beginTransaction()
                .add(R.id.My_Container_1_ID, "your fragment here")
                .commit();
    }