private void doesExist(String email) {
    db.collection("Users")
      .whereEqualTo("email", email)
      .get()
      .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {
              if (task.isSuccessful()) {
                  for (QueryDocumentSnapshot document : task.getResult()) {
                      name = document.getString("name");
                  }
                  Toast.makeText(AddFriend.this, name, Toast.LENGTH_SHORT).show();
              }
          }
      });
}