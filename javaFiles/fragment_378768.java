firebaseListAdapter = new FirebaseListAdapter<User>(this, User.class, android.R.layout.simple_list_item_1, databaseReference) {
    @Override
    protected void populateView(View v, User user, int position) {
        TextView textView = (TextView) v.findViewById(android.R.id.text1);
        String userKey = this.getRef(position).getKey();
        textView.setText(userKey);
    }
};