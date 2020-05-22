String UID;

FirebaseListAdapter<User> searchAdapter = new FirebaseListAdapter<User>(getActivity(), User.class, R.layout.user_layout, mRef) {
        @Override
        protected void populateView(View v, User model, int position) {
            // If you really need to set the UID here              
            // model.setUID = getRef(position).getKey();
            // Otherwise, I would just set a String field as shown 
            //and pass it with the intent to get the UID 
            //in the profile Activity
            UID = getRef(position).getKey
            ((TextView) v.findViewById(R.id.text1)).setText(model.getName());
            ((TextView) v.findViewById(R.id.text2)).setText(model.getEmail());
                v.setOnClickListener(MainActivity.this);
        }
    };
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putStringExtra(UID_EXTRA, UID);
        startActivity(intent);
    }