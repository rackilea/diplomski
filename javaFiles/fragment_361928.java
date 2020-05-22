BaseAdapter adapter = new SimpleAdapter(getActivity(), feedList,
R.layout.feed_item_view, new String[] { TAG_MESSAGE, TAG_NAME,
TAG_ID }, new int[] { R.id.message, R.id.author,
R.id.id_tv }); //initialize adapter

 listView.setAdapter(adapter); //set adapter
 adapter.notifyDataSetChanged();