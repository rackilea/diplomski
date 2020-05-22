public OnClickListener moreListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
        adapter = null;
        myStringArray1.add("Andrea");
        adapter = new CustomAdapter(getActivity(), R.layout.row, myStringArray1);
        myListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }       
};