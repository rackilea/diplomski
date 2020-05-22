public void onDataChange(DataSnapshot dataSnapshot) {
        EditText Name = (EditText) rootView.findViewById(R.id.Name);
        ImageView profilePic = (ImageView)rootView.findViewById(R.id.profilePic);

            String image = dataSnapshot.child("Image").getValue().toString();

           Picasso.get().load(image).into(profilePic);

        }