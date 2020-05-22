@Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    // Initially there is no data 
    setEmptyText("No Data Here");

    // Create an empty adapter we will use to display the loaded data.
    mAdapter = new CustomArrayAdapter(getActivity());
    setListAdapter(mAdapter);
}