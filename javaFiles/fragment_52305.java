db.collection(DBMeta.COLLECTION_ROUTE).document(routeIntent.getId()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                Map<String, Object> departureMap = (Map<String, Object>) map.get("departure");
                for (Map.Entry<String, Object> entry : departureMap.entrySet()) {
                    Log.d(TAG, entry.getKey());
                    Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : innerMap.entrySet()) {
                        Log.d(TAG, e.getValue().toString());
                    }
                }
            }
        }
    }
});