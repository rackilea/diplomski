public interface GetUserNameCallback {
  void onUserExists(String name);
  void onUserDoesNotExist();
}
private void doesExist(String email, UserExistsCallback callback) {
    db.collection("Users")
      .whereEqualTo("email", email)
      .get()
      .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {
              if (task.isSuccessful()) {
                  String name;
                  for (QueryDocumentSnapshot document : task.getResult()) {
                      name = document.getString("name");
                  }
                  callback.onUserExists(name);
              }
              else {
                  callback.onUserDoesNotExist();
              }
          }
      });
}