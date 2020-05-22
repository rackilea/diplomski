if (InternetStatus.getInstance(holder.blogLikeBtn.getContext()).isOnline()) {
        //Get Likes
        firebaseFirestore.collection("Posts/" + blogPostId + "/Likes").document(currentUserId).addSnapshotListener(((Main2Activity) context), new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {

                if (e != null) {
                    Log.w(TAG, "listening failed", e);
                    return;
                }

                if (documentSnapshot.exists()) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder.blogLikeBtn.setImageDrawable(context.getDrawable(R.mipmap.action_like_accent));
                    } else {
                        holder.blogLikeBtn.setImageDrawable(context.getResources().getDrawable(R.mipmap.action_like_accent));
                    }
                } else {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder.blogLikeBtn.setImageDrawable(context.getDrawable(R.mipmap.action_like_gray));
                    } else {
                        holder.blogLikeBtn.setImageDrawable(context.getResources().getDrawable(R.mipmap.action_like_gray));
                    }
                }

            }
        });
    holder.blogLikeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            firebaseFirestore.collection("Posts/" + blogPostId + "/Likes").document(currentUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if(!task.getResult().exists()){

                        Map<String, Object> likesMap = new HashMap<>();
                        likesMap.put("timestamp", FieldValue.serverTimestamp());

                        firebaseFirestore.collection("Posts/" + blogPostId + "/Likes").document(currentUserId).set(likesMap);

                    } else {

                        firebaseFirestore.collection("Posts/" + blogPostId + "/Likes").document(currentUserId).delete();

                    }

                }
            });
        }
    });
        holder.blogCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commentIntent = new Intent(context, CommentsActivity.class);
                context.startActivity(commentIntent);

            }
        });
    }else{

            Toast.makeText(context, "Check Internet", Toast.LENGTH_SHORT).show();
        }
}