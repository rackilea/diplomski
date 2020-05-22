List<Foo> bbcNewsList;
// Fill bbcNewsList with data

mAdapter = new MyCustomAdapter(getActivity(),bbcNewsList);
mListView.setAdapter(mAdapter);
//Continue instantiation as needed