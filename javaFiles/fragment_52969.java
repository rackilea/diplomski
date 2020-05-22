List<String> listOfData = new ArrayList<>();
SimpleStringRecyclerViewAdapter adapter = new SimpleStringRecyclerView(context, listOfData);
recyclerView.setAdapter(adapter);
//Now add more content to the list
listOfData.add("new item");
listOfData.add("another item");
//This notifies the adapter and the list that the content has changed
adapter.notifyDataSetChanged();