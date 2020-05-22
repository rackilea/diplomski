FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
rootRef.collection("Ads").whereEqualTo("user_id", user_id).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Map<String, Object> map = (Map<String, Object>) document.get("imgUri");
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Log.d(TAG, entry.getValue().toString());
                }
            }
        }
    }
});