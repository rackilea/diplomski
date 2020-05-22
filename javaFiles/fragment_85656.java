db.collection("users").document(email).collection("Group").document(groupTitle).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                ArrayList<String> arrayList = (ArrayList<String>) document.get("partecipant");
                //Do what you need to do with your ArrayList
                for (String s : arrayList) {
                    Log.d(TAG, s);
                }
            }
        }
    }
});