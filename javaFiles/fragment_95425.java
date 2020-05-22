private void fillListViewStores() {

    ArrayList<Store> stores = dbHelper.getStores();
    final ArrayAdapter<Store> listViewStoresAdapter = new ArrayAdapter<Store>(this, android.R.layout.simple_list_item_1, stores);

    for (Store s : stores) {
        final Store store = s;
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                store.setVillage(jsonHelper.getVillage(result));
                listViewStoresAdapter.notifyDataSetChanged();
            }
        });
        httpReader.execute("http://storevillages.com/villages?search=id&value=" + store.getId());
    }

    ListView listViewStores = (ListView) findViewById(R.id.stores_listViewStores);
    listViewStores.setAdapter(listViewStoresAdapter);
}