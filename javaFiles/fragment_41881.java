@Override
public void onStart() {
    docRef = mDatabase.collection("users").document(uId);
    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            if (documentSnapshot.exists()){
                User user = documentSnapshot.toObject(User.class);

                UserName.setText(user.getName());
                UserInfo.setText(user.getInfo());

                // Set the visibility to VISIBLE again here
                UserName.setVisibility(View.VISIBLE);
                UserInfo.setVisibility(View.VISIBLE);
            } else {
                Log.e(TAG,"Document does not exits");
            }
        }
    });
    super.onStart();
}