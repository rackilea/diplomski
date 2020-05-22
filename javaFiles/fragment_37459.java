System.out.println("Before starting query");
db.collection("Users")
  .whereEqualTo("email", email)
  .get()
  .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
      @Override
      public void onComplete(@NonNull Task<QuerySnapshot> task) {
          System.out.println("Got documents");
      }
  });
System.out.println("After starting query");