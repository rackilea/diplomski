private void displayPhotos(){
    if(mPhotos != null){
        Collections.sort(mPhotos, new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o2.getDate_created().compareTo(o1.getDate_created());
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecView.setLayoutManager(llm);
        mAdapter.notifyDataSetChanged();

    }
}