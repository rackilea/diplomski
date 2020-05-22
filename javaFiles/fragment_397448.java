// Update one field, creating the document if it does not already exist.
Map<String, Object> data = new HashMap<>();
data.put("capital", true);

db.collection("cities").document("BJ")
        .set(data, SetOptions.merge());