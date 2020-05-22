if(receiverList.size() != 0) {
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
            view.setBackgroundColor(Color.RED);
            TextView receiverIdTextView = (TextView) view.findViewById(R.id.receiverId);
            selectionId = Integer.valueOf(receiverIdTextView.getText().toString());
            ((SimpleAdapter) getListAdapter()).notifyDataSetChanged();
         }

    });
    SimpleAdapter adapter = getNewAdapter();
    setListAdapter(adapter);

}