@Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRecyclerview = view.findViewById(...);
    if (mAdapter == null) {
        mAdapter = new FirestoreRecyclerAdapter(...)
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.startListening();
    }
}

@Override public void onDestroyView() {
    super.onDestroyView();
    mAdapter.stopListening();
}