@Override
public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    myViewHolder.name.setText(profiles.get(i).getName());
    Picasso.get().load(profiles.get(i).getProfilePic()).into(myViewHolder.profilePic);  
    mViewHolder.mView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startImageActivity(profiles.get(i).getProfilePic());
        }
    });
}