@Override
    public void showData(ArrayList<User> contacts) {
        this.contacts.addAll(contacts);
        //contactAdapter = new ContactAdapter(contacts, new OnItemClickListenerUser() {
        //    @Override
        //      public void onItemClick(User user) {

        //    }
        //});
        contactAdapter.notifyDataSetChanged();

    }