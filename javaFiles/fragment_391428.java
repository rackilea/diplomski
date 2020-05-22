private boolean updateProgress (String title, String desc, String id, String property, String progress) {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                           .getReference().child("maintenance");
    FirebaseUser user = mAuth.getCurrentUser();
    String uid = user.getUid();

    Map<String, Object> params = new HashMap<>();

    params.put("progress", progress);  // put only params you want to update

    databaseReference.child(uid)
                     .child(id)
                     .updateChildren(params);

    Toast.makeText(this, "Maintenance Updated Updated Successfully", Toast.LENGTH_LONG).show();
    return true;
}