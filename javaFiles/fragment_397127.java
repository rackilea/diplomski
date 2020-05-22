uploadTask.addOnSuccessListener(taskSnapshot -> {
            Toast.makeText(getActivity(), "Post Success", Toast.LENGTH_SHORT).show();

            //insert the download url into the firebase database
            //Uri firebaseUri = taskSnapshot.getDownloadUrl();
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Uri downloadUrl = uri;
                    Log.d(TAG, "onSuccess: firebase download url: " + firebaseUri.toString());
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    Post post = new Post();
                    post.setImage(downloadUrl.toString());
                    post.setCity(mCity.getText().toString());
                    post.setContact_email(mContactEmail.getText().toString());
                    post.setCountry(mCountry.getText().toString());
                    post.setDescription(mDescription.getText().toString());
                    post.setPost_id(postId);
                    post.setPrice(mPrice.getText().toString());
                    post.setState_province(mStateProvince.getText().toString());
                    post.setTitle(mTitle.getText().toString());
                    post.setUser_id(FirebaseAuth.getInstance().getCurrentUser().getUid());

                    reference.child(getString(R.string.node_posts))
                            .child(postId)
                            .setValue(post);

                    resetFields();
                }
            })