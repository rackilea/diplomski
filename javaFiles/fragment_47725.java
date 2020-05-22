reference.child("Users").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        for (DataSnapshot ds : dataSnapshot.getChildren()){
            information.setName(ds.child("name").getValue(String.class));
            information.setImage(ds.child("image").getValue(String.class));
            username.setText(information.getName());
            String image = information.getImage();
            try {
                Picasso.get().load(image).into(profileImage);
            } catch (Exception e){
                Picasso.get().load(R.drawable.user).into(profileImage);
            }

        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

        Toasty.error(MainActivity.this, "Error: "+ databaseError.getMessage(),
                Toasty.LENGTH_SHORT, true).show();
    }
});