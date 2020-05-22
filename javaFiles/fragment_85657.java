db.collection("users").document(email).collection("Group").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                if (document.exists()) {
                    ArrayList<String> arrayList = (ArrayList<String>) document.get("partecipant");
                    //Do what you need to do with your ArrayList
                    for (String s : arrayList) {
                        Log.d(TAG, s);
                    }
                }
            }
        }
    }
});