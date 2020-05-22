private void insertUserData(){
    FirebaseUser user = auth.getCurrentUser();
    String uid = user.getUid();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> user = new HashMap<>();
    user.put("first", "Ada");
    user.put("last", "Lovelace");
    user.put("born", 1815);

    // Add a new document with a generated ID
    db.collection("users")
            .document(uid)
            .set(user);
}