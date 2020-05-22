private void prepareData() {

    DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
    Log.d("Reading: ", "Reading all contacts..");
    List<Bean> beanList = handler.getAllContacts();
    this.beanList.addAll(beanList);
    mAdapter.notifyDatasetChanged();

}